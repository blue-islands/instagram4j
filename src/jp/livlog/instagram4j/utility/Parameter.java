package jp.livlog.instagram4j.utility;

public class Parameter {

    private String parameter;

    private String value;


    public Parameter(final String parameter, final String value) {

        this.parameter = parameter;
        this.value = value;
    }


    /**
     * @return parameter
     */
    public String getParameter() {

        return parameter;
    }


    /**
     * @param parameter セットする parameter
     */
    public void setParameter(final String parameter) {

        this.parameter = parameter;
    }


    /**
     * @return value
     */
    public String getValue() {

        return value;
    }


    /**
     * @param value セットする value
     */
    public void setValue(final String value) {

        this.value = value;
    }
}
