import java.util.Scanner;
public class BTT3 
{
    protected String maSach;
    protected String tenSach;
    protected String tacGia;
    protected int namXuatBan;
    protected double donGia;
    protected int soLuong;
    protected double thanhTien;
    protected double phiVanChuyen;
    protected double tongTienNhap;
    public void nhap() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        tacGia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = sc.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        sc.close();
    }
    public void tinhTien() 
    {
        thanhTien = donGia * soLuong;
        phiVanChuyen = thanhTien * 0.05;
        tongTienNhap = thanhTien + phiVanChuyen;
    }
    public void xuat() 
    {
        System.out.println("\n--- THONG TIN SACH ---");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia + " VND");
        System.out.println("So luong: " + soLuong);
        System.out.println("Thanh tien: " + thanhTien + " VND");
        System.out.println("Phi van chuyen: " + phiVanChuyen + " VND");
        System.out.println("Tong tien nhap: " + tongTienNhap + " VND");
    }
    public static void main(String[] args) 
    {
        BTT3 sach = new BTT3();
        sach.nhap();
        sach.tinhTien();
        sach.xuat();
    }
}