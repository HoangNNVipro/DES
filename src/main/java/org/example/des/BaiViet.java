package org.example.des;

//Cần import những thư viện này của Joup
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//Cần import những thư viện này của gson
import com.google.gson.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import com.google.gson.Gson;

public class BaiViet {
    private String link;
    private String nguon;
    private String tieuDe;
    private String chuyenMuc;
    private String tacGia;
    private String thoigian;
    private String tags;
    private String noidung;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getNguon() {
        return nguon;
    }

    public void setNguon(String nguon) {
        this.nguon = nguon;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenMuc() {
        return chuyenMuc;
    }

    public void setChuyenMuc(String chuyenMuc) {
        this.chuyenMuc = chuyenMuc;
    }

    public void saveToStoredFile (){
        try {
            //Ghi thông tin đối tượng vào Stored_File.json
            FileReader fileReader = new FileReader("Stored_File.json");
            JsonParser jsonParser = new JsonParser();
            JsonArray dataArray = (JsonArray) jsonParser.parse(fileReader);

            JsonObject newObject = new JsonObject();
            newObject.addProperty("Link",this.getLink() );
            newObject.addProperty("Nguồn", this.getNguon() );
            newObject.addProperty("Tiêu đề", this.getTieuDe() );
            newObject.addProperty("Chuyên mục", this.getChuyenMuc() );
            newObject.addProperty("Tác giả", this.getTacGia() );
            newObject.addProperty("Ngày tạo", this.getThoigian() );
            newObject.addProperty("Tags", this.getTags() );
            newObject.addProperty("Nội dung", this.getNoidung() );

            // Add the new object to the JsonArray
            dataArray.add(newObject);
            int Size = dataArray.size();

            FileWriter fw = new FileWriter("Stored_File.json");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("[");
            bw.newLine();
            for (int i=0; i<Size-1; i++){
                String o = dataArray.get(i).toString();
                bw.write(o);
                bw.write(",");
                bw.newLine();
            }
            String o = dataArray.get(Size-1).toString();
            bw.write(o);
            bw.newLine();
            bw.write("]");
            bw.close();
            fw.close();

            //Ghi thông tin đối tượng vào Stored_File.csv
            BufferedWriter writer = new BufferedWriter(new FileWriter("Stored_File.csv",true));
            writer.write(
                    this.getLink() + ", " +
                            this.getNguon() + ", " +
                            this.getTieuDe() + ", " +
                            this.getChuyenMuc() + ", " +
                            this.getTacGia() + ", " +
                            this.getThoigian() + ", " +
                            this.getTags() + ", " +
                            this.getNoidung()
            );
            writer.newLine();
            writer.close();

        } catch (Exception e) {

        }
    }

}
