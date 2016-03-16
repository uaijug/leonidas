package br.com.uaijug.leonidas.model.domain;

public enum GenderType {
    MALE("Masculino"), FEMALE("Feminino");

    private String sexType;

    private GenderType(String sexType) {
        this.sexType = sexType;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

}
