package org.example.des;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.FileReader;
import java.net.URI;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {

    @FXML
    private AnchorPane macdinh;

    @FXML
    private Button macdinh_btn;

    @FXML
    private AnchorPane timkiem;

    @FXML
    private Button timkiem_btn;

    @FXML
    private AnchorPane trangchu;

    @FXML
    private Button trangchu_btn;

    @FXML
    private AnchorPane truyxuat;

    @FXML
    private Button truyxuat_btn;

    @FXML
    private AnchorPane tukhoa;

    @FXML
    private Button tukhoa_btn;

    @FXML
    private AnchorPane tuvan;

    @FXML
    private Button tuvan_btn;

    //Trích xuất
    @FXML
    private ComboBox chonnguon_tx_cbb;

    @FXML
    private Label label_tx;

    @FXML
    private TextField Link;

    @FXML
    private Button motrang_tx_btn;

    @FXML
    private Button tieptheo_tx_btn;

    public int check(String url) {
        try {
            FileReader fileReader = new FileReader("Stored_File.json");
            JsonParser jsonParser = new JsonParser();
            JsonArray dataArray = (JsonArray) jsonParser.parse(fileReader);

            int Size = dataArray.size();
            int xn = 0;

            for (int i = 0; i < Size; i++) {
                JsonObject o = (JsonObject) dataArray.get(i);
                String s = o.get("Link").toString();
                if (s.indexOf(url) >= 0) {
                    xn = 1;
                }
            }

            if (xn == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
        }
        return 0;
    }

    @FXML
    public void motrang_tx(ActionEvent event) {
        String nguon_tx = (String) chonnguon_tx_cbb.getValue();
        try {
            URI uri = new URI(nguon_tx);

            // Kiểm tra xem máy tính có hỗ trợ mở đường link không
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Mở trang web trong trình duyệt mặc định
                    desktop.browse(uri);
                } else {
                    System.out.println("Không thể mở trình duyệt web trên máy tính này.");
                }
            } else {
                System.out.println("Không thể mở trình duyệt web trên máy tính này.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void capNhat(ActionEvent event) {

        String url = Link.getText();
        if (url.indexOf("https://blockchain.news/news") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new Blockchain(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        } else if (url.indexOf("https://www.forbes.com/sites/digital-assets") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new Forbes(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        } else if (url.indexOf("https://www.coindesk.com") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new Coindesk(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        }else if (url.indexOf("https://www.the-blockchain.com/") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new The_blockchain(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        }else if (url.indexOf("https://decrypt.co/") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new Decrypt(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        }else if (url.indexOf("https://u.today/") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new U_today(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        }else if (url.indexOf("https://blockworks.co/news/") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new Blockworks(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        }else if (url.indexOf("https://www.bsc.news/post/") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new Bsc_news(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        }else if (url.indexOf("https://ripplecoinnews.com/") >= 0) {
            if ((check(url)) == 1) label_tx.setText("Bài viết đã có trong cơ sở dữ liệu từ trước.");
            else {
                new Ripplecoinnews(url).saveToStoredFile();
                label_tx.setText("Cập nhật thông tin bài viết thành công !");
            }
        }else {
            label_tx.setText("Phần mềm chưa cập nhật nguồn website này.");
        }
    }

    @FXML
    public void tieptheo_tx(ActionEvent event) {
        chonnguon_tx_cbb.setValue(null);
        Link.clear();
        label_tx.setText("");
    }

//Trích xuất

//Tìm kiếm mặc định

    @FXML
    private ComboBox chonnguon_tk_cbb;

    @FXML
    public void chonnguon_tk(ActionEvent event) {
        try {
            String nguon_tk = (String) chonnguon_tk_cbb.getValue();

            for (int i = dataArray_tk1.size() - 1; i >= 0; i--) {
                dataArray_tk1.remove(i);
            }
            chuyenmuc_tk_cbb.setValue(null);
            ta_tk.clear();

            Set<String> chuyenmuc_tk_set = new HashSet<>();
            int Size = dataArray_tk.size();
            for (int i = 0; i < Size; i++) {
                JsonObject o = (JsonObject) dataArray_tk.get(i);
                String s = o.get("Nguồn").toString();
                if (s.indexOf(nguon_tk) >= 0) {
                    chuyenmuc_tk_set.add(o.get("Chuyên mục").toString());
                    dataArray_tk1.add(o);
                }
            }
            ObservableList<String> list = FXCollections.observableArrayList(chuyenmuc_tk_set);
            chuyenmuc_tk_cbb.setItems(list);
            chuyenmuc_tk_set.clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private ComboBox chuyenmuc_tk_cbb;

    @FXML
    public void chuyenmuc_tk(ActionEvent event) {
        try {
            String chuyenmuc_tk = (String) chuyenmuc_tk_cbb.getValue();

            for (int i = dataArray_tk2.size() - 1; i >= 0; i--) {
                dataArray_tk2.remove(i);
            }
            tacgia_tk_cbb.setValue(null);
            ta_tk.clear();

            Set<String> tacgia_tk_set = new HashSet<>();
            int Size = dataArray_tk1.size();
            for (int i = 0; i < Size; i++) {
                JsonObject o = (JsonObject) dataArray_tk1.get(i);
                String s = o.get("Chuyên mục").toString();
                if (s.indexOf(chuyenmuc_tk) >= 0) {
                    tacgia_tk_set.add(o.get("Tác giả").toString());
                    dataArray_tk2.add(o);
                }
            }
            ObservableList<String> list = FXCollections.observableArrayList(tacgia_tk_set);
            tacgia_tk_cbb.setItems(list);
            tacgia_tk_set.clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private ComboBox tacgia_tk_cbb;

    @FXML
    public void tacgia_tk(ActionEvent event) {
        try {
            String tacgia_tk = (String) tacgia_tk_cbb.getValue();

            for (int i = dataArray_tk3.size() - 1; i >= 0; i--) {
                dataArray_tk3.remove(i);
            }
            baiviet_tk_cbb.setValue(null);
            ta_tk.clear();

            Set<String> baiviet_tk_set = new HashSet<>();
            int Size = dataArray_tk2.size();
            for (int i = 0; i < Size; i++) {
                JsonObject o = (JsonObject) dataArray_tk2.get(i);
                String s = o.get("Tác giả").toString();
                if (s.indexOf(tacgia_tk) >= 0) {
                    baiviet_tk_set.add(o.get("Tiêu đề").toString());
                    dataArray_tk3.add(o);
                }
            }
            ObservableList<String> list = FXCollections.observableArrayList(baiviet_tk_set);
            baiviet_tk_cbb.setItems(list);
            baiviet_tk_set.clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private ComboBox baiviet_tk_cbb;

    @FXML
    private TextArea ta_tk;

    @FXML
    public void baiviet_tk(ActionEvent event) {
        try {
            String baiviet_tk = (String) baiviet_tk_cbb.getValue();

            //set scroll về null
            int Size = dataArray_tk3.size();
            for (int i = 0; i < Size; i++) {
                JsonObject o = (JsonObject) dataArray_tk3.get(i);
                String s = o.get("Tiêu đề").toString();
                if (s.indexOf(baiviet_tk) >= 0) {
                    ta_tk.setText(" Link: " + o.get("Link").toString() + "\n\n"+
                            " Nguồn: " + o.get("Nguồn").toString() + "\n\n"+
                            " Tiêu đề: " + o.get("Tiêu đề").toString() + "\n\n"+
                            " Chuyên mục: " + o.get("Chuyên mục").toString() + "\n\n"+
                            " Tác giả: " + o.get("Tác giả").toString() + "\n\n"+
                            " Ngày tạo: " + o.get("Ngày tạo").toString() + "\n\n"+
                            " Tags: " + o.get("Tags").toString() + "\n\n"+
                            " Nội dung: " + "\n\n"  + o.get("Nội dung").toString()
                    );
                }
            }
        } catch (Exception e) {

        }
    }

    @FXML
    private Button tieptuc_tk_btn;

    @FXML
    public void tieptuc_tk(ActionEvent event) {
        chonnguon_tk_cbb.setValue(null);
        chuyenmuc_tk_cbb.setValue(null);
        tacgia_tk_cbb.setValue(null);
        baiviet_tk_cbb.setValue(null);
        ta_tk.clear();
    }

//Tìm kiếm mặc định

//Tìm kiếm từ khóa

    @FXML
    private TextField tukhoa_tktk_tf;

    @FXML
    private Button timkiem_tktk_btn;

    @FXML
    private Label thongbao_tktk_lb;

    @FXML
    public void timkiem_tktk(ActionEvent event) {
        try {
            String tukhoa = tukhoa_tktk_tf.getText();
            int xn = 0;

            for (int i = dataArray_tk4.size() - 1; i >= 0; i--) {
                dataArray_tk4.remove(i);
            }
            //noidung_tktk_sp.setContent(null);
            ta_tktk.clear();

            Set<String> baiviet_tktk_set = new HashSet<>();
            int Size = dataArray_tk.size();
            for (int i = 0; i < Size; i++) {
                JsonObject o = (JsonObject) dataArray_tk.get(i);
                if ((o.get("Link").toString().indexOf(tukhoa) >= 0) || (o.get("Nguồn").toString().indexOf(tukhoa) >= 0)
                || (o.get("Tiêu đề").toString().indexOf(tukhoa) >= 0) || (o.get("Chuyên mục").toString().indexOf(tukhoa) >= 0)
                || (o.get("Tác giả").toString().indexOf(tukhoa) >= 0) || (o.get("Ngày tạo").toString().indexOf(tukhoa) >= 0)
                || (o.get("Tags").toString().indexOf(tukhoa) >= 0) || (o.get("Nội dung").toString().indexOf(tukhoa) >= 0)) {
                    baiviet_tktk_set.add(o.get("Tiêu đề").toString());
                    dataArray_tk4.add(o);
                    xn = 1;
                }
            }
            ObservableList<String> list = FXCollections.observableArrayList(baiviet_tktk_set);
            baiviet_tktk_cbb.setItems(list);
            baiviet_tktk_set.clear();
            if(xn==0) thongbao_tktk_lb.setText("Không tìm được bài viết nào có từ khóa này.");
            else thongbao_tktk_lb.setText("Đã tìm được bài viết có từ khóa này.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private Button tieptuc_tktk_btn;

    @FXML
    public void tieptuc_tktk(ActionEvent event){
        tukhoa_tktk_tf.clear();
        baiviet_tktk_cbb.setValue(null);
        //noidung_tktk_sp.setContent(null);
        thongbao_tktk_lb.setText(null);
        ta_tktk.clear();
    }

    @FXML
    private ComboBox baiviet_tktk_cbb;

    @FXML
    private TextArea ta_tktk;

    @FXML
    public void baiviet_tktk(ActionEvent event){
        try{
            String baiviet = (String) baiviet_tktk_cbb.getValue();


            int Size = dataArray_tk4.size();
            for (int i = 0; i < Size; i++) {
                JsonObject o = (JsonObject) dataArray_tk4.get(i);
                String s = o.get("Tiêu đề").toString();
                if (s.indexOf(baiviet) >= 0) {
                    ta_tktk.setText(" Link: " + o.get("Link").toString() + "\n\n"+
                                    " Nguồn: " + o.get("Nguồn").toString() + "\n\n"+
                                    " Tiêu đề: " + o.get("Tiêu đề").toString() + "\n\n"+
                                    " Chuyên mục: " + o.get("Chuyên mục").toString() + "\n\n"+
                                    " Tác giả: " + o.get("Tác giả").toString() + "\n\n"+
                                    " Ngày tạo: " + o.get("Ngày tạo").toString() + "\n\n"+
                                    " Tags: " + o.get("Tags").toString() + "\n\n"+
                                    " Nội dung: " + "\n\n"  + o.get("Nội dung").toString()
                    );
                }
            }
        } catch (Exception e) {

        }
    }

//Tìm kiếm từ khóa

    //Set up ban đầu
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //setup chonnguon_tx_cbb
        ArrayList<String> danhSach = new ArrayList<String>();
        danhSach.add("https://blockchain.news");
        danhSach.add("https://www.forbes.com");
        danhSach.add("https://www.coindesk.com");
        danhSach.add("https://www.the-blockchain.com");
        danhSach.add("https://decrypt.co");
        danhSach.add("https://u.today");
        danhSach.add("https://blockworks.co");
        danhSach.add("https://www.bsc.news");
        danhSach.add("https://ripplecoinnews.com");

        ObservableList<String> list = FXCollections.observableArrayList(danhSach);
        chonnguon_tx_cbb.setItems(list);
        chonnguon_tk_cbb.setItems(list);

        set_dataArray_tk();
    }

    private JsonArray dataArray_tk4 = new JsonArray();
    private JsonArray dataArray_tk3 = new JsonArray();
    private JsonArray dataArray_tk2 = new JsonArray();
    private JsonArray dataArray_tk1 = new JsonArray();
    private JsonArray dataArray_tk = new JsonArray();

    public void set_dataArray_tk() {
        try {
            FileReader fileReader_tk = new FileReader("Stored_File.json");
            JsonParser jsonParser_tk = new JsonParser();
            dataArray_tk = (JsonArray) jsonParser_tk.parse(fileReader_tk);
        } catch (Exception e) {

        }
    }
//Set up ban đầu

    public void switchForm(ActionEvent event) {
        if (event.getSource() == trangchu_btn) {
            trangchu.setVisible(true);
            truyxuat.setVisible(false);
            timkiem.setVisible(false);
            tuvan.setVisible(false);
            macdinh.setVisible(false);
            tukhoa.setVisible(false);
        } else if (event.getSource() == truyxuat_btn) {
            trangchu.setVisible(false);
            truyxuat.setVisible(true);
            timkiem.setVisible(false);
            tuvan.setVisible(false);
            macdinh.setVisible(false);
            tukhoa.setVisible(false);
        } else if (event.getSource() == timkiem_btn) {
            trangchu.setVisible(false);
            truyxuat.setVisible(false);
            timkiem.setVisible(true);
            tuvan.setVisible(false);
            macdinh.setVisible(false);
            tukhoa.setVisible(false);
        } else if (event.getSource() == tuvan_btn) {
            trangchu.setVisible(false);
            truyxuat.setVisible(false);
            timkiem.setVisible(false);
            tuvan.setVisible(true);
            macdinh.setVisible(false);
            tukhoa.setVisible(false);
        } else if (event.getSource() == macdinh_btn) {
            trangchu.setVisible(false);
            truyxuat.setVisible(false);
            timkiem.setVisible(false);
            tuvan.setVisible(false);
            macdinh.setVisible(true);
            tukhoa.setVisible(false);
        } else if (event.getSource() == tukhoa_btn) {
            trangchu.setVisible(false);
            truyxuat.setVisible(false);
            timkiem.setVisible(false);
            tuvan.setVisible(false);
            macdinh.setVisible(false);
            tukhoa.setVisible(true);
        }
    }
}
