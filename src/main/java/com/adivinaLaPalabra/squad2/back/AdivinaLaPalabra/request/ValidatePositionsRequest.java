package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.request;

public class ValidatePositionsRequest {

    String pos0;
    String pos1;
    String pos2;
    String pos3;
    String pos4;

    public ValidatePositionsRequest(String pos0, String pos1, String pos2, String pos3, String pos4) {
        this.pos0 = pos0;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
    }

    public String getPos0() {
        return pos0;
    }

    public void setPos0(String pos0) {
        this.pos0 = pos0;
    }

    public String getPos1() {
        return pos1;
    }

    public void setPos1(String pos1) {
        this.pos1 = pos1;
    }

    public String getPos2() {
        return pos2;
    }

    public void setPos2(String pos2) {
        this.pos2 = pos2;
    }

    public String getPos3() {
        return pos3;
    }

    public void setPos3(String pos3) {
        this.pos3 = pos3;
    }

    public String getPos4() {
        return pos4;
    }

    public void setPos4(String pos4) {
        this.pos4 = pos4;
    }

    public String wordSerialize() {
        return this.getPos0() + this.getPos1() + this.getPos2() + this.getPos3() + this.getPos4();
    }

}
