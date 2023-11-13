package Model;

import java.sql.Date;

public class Matricula {
    private int matricula;
    
    private Date dataMatricula;
    
    public Matricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
    
    public Matricula(int matricula) {
    	setMatricula(matricula);
    }

    public Matricula(int matricula, Date dataMatricula) {
		this.matricula = matricula;
		this.dataMatricula = dataMatricula;
	}

	public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
	public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
