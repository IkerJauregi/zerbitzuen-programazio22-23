import java.io.Serializable;

public class Objetua implements Serializable{
    public String mezua;
    public int zenbakia;


    public Objetua (){

    }

    public Objetua (String mezua, int zenbakia){
        this.mezua = mezua;
        this.zenbakia = zenbakia;
    }


    public String getMezua(){
        return mezua;
    }

    public void setMezua(String mezua){
        this.mezua = mezua;
    }

    public int getZenbakia(){
        return zenbakia;
    }

    public void setZenbakia(int zenbakia){
        this.zenbakia = zenbakia;
    }

    @Override
    public String toString() {
        return "Objetua[Mezua = " + this.getMezua() + "; Zenbakia = " + this.getZenbakia() + "]";
    }

}