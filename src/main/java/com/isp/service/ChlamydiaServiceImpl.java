package com.isp.service;

import com.isp.dto.Card;
import com.isp.dto.ChlamydiaPatient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class ChlamydiaServiceImpl implements ChlamydiaService {
    // Решения. То, что записывается в Cards!
    private static final String atRiskByAgeMessage = "Patient is at risk for chlamydia infection by age group, no screening test available in past 1 year";
    private static final String testProposal = "Need Chlamydia Screening test";

    private static final String notAtRiskByAgeMessage = "Patient is not at risk for chlamydia infection";
    private static final String noTestProposal = "No test proposal";

    // Методы для принятия решения.
    private int yearsPassed(String date) {
        return Period.between(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now()).getYears();
    }

    private boolean isFemale(ChlamydiaPatient p) {
        return Objects.equals("female", p.getGender());
    }

    private boolean atRiskByAgeGroup(ChlamydiaPatient p) {
        return p.getAgeInYears() >=16 && p.getAgeInYears() <= 24;
    }

    private boolean hasEvidenceOfSexualActivity(ChlamydiaPatient p) {
        return p.getSexuallyActive() == 1;
    }

    private boolean hasChlamydiaTest(ChlamydiaPatient p) {
        return p.getDiagnosticReports().get("Laboratory Test, Result: Chlamydia Screening") != null &&
                yearsPassed(p.getDiagnosticReports().get("Laboratory Test, Result: Chlamydia Screening").getObservedAtTime()) <= 1 &&
                p.getDiagnosticReports().get("Laboratory Test, Result: Chlamydia Screening").getValue() != null;
    }

    private boolean hasSTIriskFactor(ChlamydiaPatient p) {
        return // p.conditions.get("Risk Evaluation, Document: Sexually Transmitted Infection") != null &&
                // yearsPassed(p.conditions.get("Risk Evaluation, Document: Sexually Transmitted Infection").effectiveTime) <= 1 ||
                p.getObservations().get("Risk Evaluation, Document: Sexually Transmitted Infection") != null &&
                        yearsPassed( p.getObservations().get("Risk Evaluation, Document: Sexually Transmitted Infection").getObservedAtTime()) <= 1;
    }

    private boolean inAtRiskAgePopulation(ChlamydiaPatient p) {
        return isFemale(p) && atRiskByAgeGroup(p) && hasEvidenceOfSexualActivity(p) && !hasChlamydiaTest(p);
    }

    private boolean inOtherAtRiskPopulation(ChlamydiaPatient p) {
        return hasSTIriskFactor(p) && !hasChlamydiaTest(p);
    }

    private boolean inAgeAndOtherAtRiskPopulation (ChlamydiaPatient p) {
        return inAtRiskAgePopulation(p) && inOtherAtRiskPopulation(p) && !hasChlamydiaTest(p);
    }

    @Override
    public Card makeDecision(ChlamydiaPatient patient) {
        return inAgeAndOtherAtRiskPopulation(patient) ?
                new Card(testProposal, atRiskByAgeMessage) : new Card(noTestProposal, notAtRiskByAgeMessage);
    }
}
