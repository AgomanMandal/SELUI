package Element;

import javafx.beans.property.SimpleStringProperty;

public class FlowSheet {
    private final SimpleStringProperty lDescription;
    private final SimpleStringProperty lPage;
    private final SimpleStringProperty lObjectproperty;
    private final SimpleStringProperty lFunction;
    private final SimpleStringProperty lFlowParameter;
    private final SimpleStringProperty ldatasheet;

    public FlowSheet(String Description, String Page, String Objectproperty, String Function, String FlowParameter,String datasheet) {
        this.lDescription = new SimpleStringProperty(Description);
        this.lPage = new SimpleStringProperty(Page);
        this.lObjectproperty = new SimpleStringProperty(Objectproperty);
        this.lFunction = new SimpleStringProperty(Function);
        this.lFlowParameter = new SimpleStringProperty(FlowParameter);
        this.ldatasheet = new SimpleStringProperty(datasheet);

        System.out.println("Values when Constructor is invoked:"+lFlowParameter);
    }

    public String getDescription() {
        return lDescription.get();
    }
    public void setDescription(String Description) {
        lDescription.set(Description);
    }

    public String getPage() {
        return lPage.get();
    }
    public void setPage(String Page) {
        lPage.set(Page);
    }

    public String getObjectproperty() {
        return lObjectproperty.get();
    }
    public void setObjectproperty(String Objectproperty) {
        lObjectproperty.set(Objectproperty);
    }

    public String getFunction() {
        System.out.println("Values when lFunction is returned:"+lFunction);
        return lFunction.get();

    }
    public void setFunction(String Function) {
        lFunction.set(Function);
    }


    public String getFlowParameter() {
        System.out.println("Values when lFlowParameter is returned:"+lFlowParameter);
        return lFlowParameter.get();
    }

    public void setFlowParameter(String FlowParameter) {
        lFlowParameter.set(FlowParameter);
        System.out.println("Values when Setter is invoked:"+lFlowParameter);
    }
    public String getDatasheet() {
        System.out.println("Values when lFlowParameter is returned:"+ldatasheet);
        return ldatasheet.get();
    }

    public void setDatasheet(String Datasheet) {
        ldatasheet.set(Datasheet);
        System.out.println("Values when Setter is invoked:"+ldatasheet);
    }

}

 

 