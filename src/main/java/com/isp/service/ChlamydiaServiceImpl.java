package com.isp.service;

import com.isp.dto.Request;
import com.isp.dto.Card;
import com.isp.dto.ChlamydiaPatient;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class ChlamydiaServiceImpl implements ChlamydiaService {

    //TODO: проверка "ну такое": говорит, что инфы больше не нужно в том случае,
    // если все поля заполнены уже приходят
    @Override
    public boolean checkPresenceOfFields(Request request) {
        boolean allPresent = request.getPrefetch().getQuestionnaireResponse().item.stream()
                .allMatch(answerItem -> Objects.nonNull(answerItem.getAnswer()) &&
                        Objects.nonNull(answerItem.getLinkId()) &&
                        Objects.nonNull(answerItem.getText()));
        return allPresent;
    }

    // Решения. То, что записывается в Cards!
    private String atRiskByAgeMessage = "Patient is at risk for chlamydia infection by age group, no screening test available in past 1 year";
    private String testProposal = "Need Chlamydia Screening test";

    private String notAtRiskByAgeMessage = "Patient is not at risk for chlamydia infection";
    private String noTestProposal = "No test proposal";

    // Методы для принятия решения.
    public int yearsPassed(String date) {
        return Period.between(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now()).getYears();
    }

    public boolean isFemale(ChlamydiaPatient p) {
        return p.gender.equals("female");
    }

    public boolean atRiskByAgeGroup(ChlamydiaPatient p) {
        return p.ageInYears >= 16 && p.ageInYears <= 24;
    }

    public boolean hasEvidenceOfSexualActivity(ChlamydiaPatient p) {
        return p.sexuallyActive == 1;
    }

    public boolean hasChlamydiaTest(ChlamydiaPatient p) {
        return p.diagnosticReports.get("Laboratory Test, Result: Chlamydia Screening") != null &&
                yearsPassed(p.diagnosticReports.get("Laboratory Test, Result: Chlamydia Screening").observedAtTime) <= 1 &&
                p.diagnosticReports.get("Laboratory Test, Result: Chlamydia Screening").value != null;
    }

    public boolean hasSTIriskFactor(ChlamydiaPatient p) {
        return // p.conditions.get("Risk Evaluation, Document: Sexually Transmitted Infection") != null &&
                // yearsPassed(p.conditions.get("Risk Evaluation, Document: Sexually Transmitted Infection").effectiveTime) <= 1 ||
                p.observations.get("Risk Evaluation, Document: Sexually Transmitted Infection") != null &&
                        yearsPassed(p.observations.get("Risk Evaluation, Document: Sexually Transmitted Infection").observedAtTime) <= 1;
    }

    public boolean inAtRiskAgePopulation (ChlamydiaPatient p) {
        return isFemale(p) && atRiskByAgeGroup(p) && hasEvidenceOfSexualActivity(p) && !hasChlamydiaTest(p);
    }

    public boolean inOtherAtRiskPopulation (ChlamydiaPatient p) {
        return hasSTIriskFactor(p) && !hasChlamydiaTest(p);
    }

    public boolean inAgeAndOtherAtRiskPopulation (ChlamydiaPatient p) {
        return inAtRiskAgePopulation(p) && inOtherAtRiskPopulation(p) && !hasChlamydiaTest(p);
    }

    //TODO: implement decision-making logic
    @Override
    public Card makeDecision(ChlamydiaPatient patient) {
        return inAgeAndOtherAtRiskPopulation(patient) ?
                new Card(testProposal, atRiskByAgeMessage) : new Card(noTestProposal, notAtRiskByAgeMessage);
    }
}
