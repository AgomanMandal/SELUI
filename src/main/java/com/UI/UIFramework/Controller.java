package com.UI.UIFramework;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.util.Callback;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

import Element.FlowSheet;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
    private TableColumn<FlowSheet,String> Descriptioncol;
    @FXML
    private TableColumn<FlowSheet,String>  Pagecol;
    @FXML
    private TableColumn<FlowSheet,String>  Objectpropertycol;
    @FXML
    private TableColumn<FlowSheet,String>  Functioncol;
    @FXML
    private TableColumn<FlowSheet,String>  FlowParametercol;

    @FXML
    private TableView<FlowSheet>  SceneFlowsheet;



    ObservableList<FlowSheet> list;

    private  ObservableList<FlowSheet> data =
            FXCollections.observableArrayList(
                    new FlowSheet("Y", "WEB", "ApeHome","Webclick","Y", "APEData"),
                    new FlowSheet("Y", "WEB", "ApeHome","Webclick","Y","APEData"),
                    new FlowSheet("Y", "WEB", "ApeHome","WebMoveToElement","Y","APEData"),
                    new FlowSheet("Y", "WEB", "ApeClientDektop|ApeHome","WebRightClick","Y","APEData"),
                    new FlowSheet("Y", "WEB", "ApeHome","Webclick","Y","APEData"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //table.setEditable(true);
        SceneFlowsheet.setEditable(true);

        Callback<TableColumn<FlowSheet,String>, TableCell<FlowSheet,String>> cellFactory =
                new Callback<TableColumn<FlowSheet,String>, TableCell<FlowSheet,String>>() {
                    public TableCell call(TableColumn<FlowSheet,String> p) {
                        return new EditingCell();
                    }
                };





        Descriptioncol.setCellValueFactory(
                new PropertyValueFactory<FlowSheet, String>("Description"));

        Descriptioncol.setCellFactory(cellFactory);
        Descriptioncol.setOnEditCommit(
                new EventHandler<CellEditEvent<FlowSheet, String>>() {
                    @Override
                    public void handle(CellEditEvent<FlowSheet, String> t) {
                        ((FlowSheet) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDescription(t.getNewValue());
                    }
                }
        );

        Pagecol.setCellValueFactory(
                new PropertyValueFactory<FlowSheet, String>("Page"));
        Pagecol.setCellFactory(cellFactory);
        Pagecol.setOnEditCommit(
                new EventHandler<CellEditEvent<FlowSheet, String>>() {
                    @Override
                    public void handle(CellEditEvent<FlowSheet, String> t) {
                        ((FlowSheet) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPage(t.getNewValue());
                    }
                }
        );

        Objectpropertycol.setCellValueFactory(
                new PropertyValueFactory<FlowSheet, String>("Objectproperty"));
        Objectpropertycol.setCellFactory(cellFactory);
        Objectpropertycol.setOnEditCommit(
                new EventHandler<CellEditEvent<FlowSheet, String>>() {
                    @Override
                    public void handle(CellEditEvent<FlowSheet, String> t) {
                        ((FlowSheet) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setObjectproperty(t.getNewValue());
                    }
                }
        );
        Functioncol.setCellValueFactory(
                new PropertyValueFactory<FlowSheet, String>("Function"));
        Functioncol.setCellFactory(cellFactory);
        Functioncol.setOnEditCommit(
                new EventHandler<CellEditEvent<FlowSheet, String>>() {
                    @Override
                    public void handle(CellEditEvent<FlowSheet, String> t) {
                        ((FlowSheet) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFunction(t.getNewValue());
                    }
                }
        );



        FlowParametercol.setCellValueFactory(
                new PropertyValueFactory<FlowSheet, String>("FlowParameter"));
        FlowParametercol.setCellFactory(cellFactory);
        FlowParametercol.setOnEditCommit(
                new EventHandler<CellEditEvent<FlowSheet, String>>() {
                    @Override
                    public void handle(CellEditEvent<FlowSheet, String> t) {
                        ((FlowSheet) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFlowParameter(t.getNewValue());
                       System.out.println("changed value in last column:"+t.getNewValue());
                    }

                }
        );






        SceneFlowsheet.setItems(data);
        data.add(new FlowSheet("desc","page","object","function1","flow1","APEData"));

        SceneFlowsheet.setItems(data);
        //SceneFlowsheet.getColumns().addAll(Descriptioncol,Pagecol,Objectpropertycol,Functioncol,FlowParametercol);

    }


















    // FOr editing in a different way
    class EditingCell extends TableCell<FlowSheet, String> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0,
                                    Boolean arg1, Boolean arg2) {
                    if (!arg2) {
                        commitEdit(textField.getText());
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
}

 