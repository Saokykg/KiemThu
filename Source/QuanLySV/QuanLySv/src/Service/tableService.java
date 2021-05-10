/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanly.Class.tbHocBong;
import quanly.Class.tbbchocphi;
import quanly.Class.tbxeploai;

/**
 *
 * @author jacky
 */
public class tableService {
    public static List<tbbchocphi> getbaocaohocphi(int n,int k) throws SQLException{
        String sql = "select l.id_lop_hoc, ten_mon_hoc, count(*), sum(hoc_phi) " +
                    "from diem d, lophoc l, monhoc m " +
                    "where m.id_mon_hoc = l.id_mon_hoc and d.id_lop_hoc = l.id_lop_hoc " +
                    "and (l.hoc_ki = ? ";
        int hk = hockiService.getHK(n,k);
        if (k==0)
            sql += " or l.hoc_ki = ? or l.hoc_ki = ? ";
        else
            if (k==-1)
                return new ArrayList<tbbchocphi>();
        sql+=") group by l.id_lop_hoc " +
             "order by l.id_lop_hoc ";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, hk);
        if (k == 0){
            stm.setInt(2, hk+1);
            stm.setInt(3, hk+2);
        }
        ResultSet rs = stm.executeQuery();
        List<tbbchocphi> tb = new ArrayList<>();
        while(rs.next()){
            tbbchocphi hp = new tbbchocphi(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
            tb.add(hp);
        }
        return tb;
    }

    protected static String diemtoxeploai(float d){
        String xeploai;
        if (d<5)      xeploai = "Yếu";
        else if (d<7) xeploai = "Trung bình";
        else if (d<8) xeploai = "Khá";
        else xeploai = "Giỏi";
        return xeploai;
    }
    
    public static List<tbxeploai> getbaocaoxeploai(int n,int k) throws SQLException{
        String sql = "select mssv, ho, ten, avg(diem_giua_ki*phantram + diem_cuoi_ki*(1-phantram)) " +
                    "from sinhvien s, diem d, monhoc m, lophoc l " +
                    "where s.id_sinh_vien = d.id_sinh_vien and m.id_mon_hoc = l.id_mon_hoc " +
                    "and l.id_lop_hoc = d.id_lop_hoc and (l.hoc_ki = ? ";
        int hk = hockiService.getHK(n,k);
        if (k==0)
            sql += "or l.hoc_ki = ? or l.hoc_ki = ? ";
        else
            if (k==-1)
                return new ArrayList<tbxeploai>();
        sql+=") group by s.id_sinh_vien order by mssv";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, hk);
        if (k == 0){
            stm.setInt(2, hk+1);
            stm.setInt(3, hk+2);
        }
        ResultSet rs = stm.executeQuery();
        List<tbxeploai> tb = new ArrayList<>();
        while(rs.next()){
            float d = rs.getFloat(4);
            String xeploai = diemtoxeploai(d);
            tbxeploai xl = new tbxeploai(rs.getString(1), rs.getString(2)+" "+ rs.getString(3), String.format("%.2f", d), xeploai);
            tb.add(xl);
        }
        return tb;
    }
    public static List<tbHocBong> getDsHocBong(int hocki) throws SQLException{
        String sql = "select s.ho, s.ten, mucdo, tien_thuong " +
                    "from sinhvien_nhan_hocbong sh, sinhvien s, hocbong h " +
                    "where sh.id_sinh_vien = s.id_sinh_vien and sh.id_hoc_bong = h.id_hoc_bong and h.hoc_ki = ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, hocki);
        List<tbHocBong> tb = new ArrayList<>();
        ResultSet rs = stm.executeQuery();
        int i = 1;
        while(rs.next()){
            tbHocBong hb = new tbHocBong(i, rs.getString(1)+" "+rs.getString(2),rs.getString(3),rs.getFloat(4));
            tb.add(hb);
            i++;
        }
        return tb;
    }
    
}
