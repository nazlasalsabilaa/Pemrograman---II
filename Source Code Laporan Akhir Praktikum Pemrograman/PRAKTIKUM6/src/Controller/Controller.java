package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Mahasiswa;

public class Controller {

    @FXML
    private TableView<Mahasiswa> table;

    @FXML
    private TableColumn<Mahasiswa, String> colNim;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    @FXML
    public void initialize() {
        colNim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));

        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
            new Mahasiswa(1,"Rusmaya Nirmala","24100101"),
            new Mahasiswa(2,"Najwa Syifa","24100102"),
            new Mahasiswa(3,"Ferdy Kesuma","24100103"),
            new Mahasiswa(4,"Laily Azizah","24100104"),
            new Mahasiswa(5,"Muhammad Ibnu Alfarizki","24100105"),
            new Mahasiswa(6,"Ahmad Rafli","24100106"),
            new Mahasiswa(7,"Aditya Saputra","24100107"),
            new Mahasiswa(8,"Muhammad Aziz Rijaldi","24100108"),
            new Mahasiswa(9,"Nafis Gilda","24100109"),
            new Mahasiswa(10,"Risky Husnul Khatimah","24100110")
        );

        table.setItems(data);
    }
}