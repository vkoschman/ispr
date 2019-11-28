package com.isp.dto;

public class Request {
    private String hook;
    private String hookInstance;
    private String fhirServer;
    private String user;
    private Prefetch prefetch;

    public Request(String hook, String hookInstance, String fhirServer, String user, Prefetch prefetch) {
        this.prefetch = prefetch;
    }
    public Request(){
    }

    public String getHook() {
        return hook;
    }

    public String getHookInstance() {
        return hookInstance;
    }

    public String getFhirServer() {
        return fhirServer;
    }

    public String getUser() {
        return user;
    }

    public Prefetch getPrefetch() {
        return prefetch;
    }

    public void setHook(String hook) {
        this.hook = hook;
    }

    public void setFhirServer(String fhirServer) {
        this.fhirServer = fhirServer;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setHookInstance(String hookInstance) {
        this.hookInstance = hookInstance;
    }
}
