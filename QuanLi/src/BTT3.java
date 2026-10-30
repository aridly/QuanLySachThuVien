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
    protected int loaiSach;
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
        System.out.println("\n--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon: ");
        loaiSach = sc.nextInt();
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
  public void phanLoaiGia()
    {
        if (donGia < 50000)
        {
            System.out.println("Sach gia thap");
        }
        else if (donGia <= 100000)
        {
            System.out.println("Sach gia trung binh");
        }
        else if (donGia <= 200000)
        {
            System.out.println("Sach gia cao");
        }
        else
        {
            System.out.println("Sach gia dac biet");
        }
    }
    public void phanLoaiTonKho()
    {
        if (soLuong == 0)
        {
            System.out.println("Het sach");
        }
        else if (soLuong <= 5)
        {
            System.out.println("Sap het");
        }
        else if (soLuong <= 20)
        {
            System.out.println("Con it");
        }
        else
        {
            System.out.println("Con nhieu");
        }
    }
    public void hienThiLoaiSach()
    {
        switch (loaiSach)
        {
            case 1:
                System.out.println("Loai sach: Sach giao khoa");
                break;
            case 2:
                System.out.println("Loai sach: Sach tham khao");
                break;
            case 3:
                System.out.println("Loai sach: Sach chuyen nganh");
                break;
            case 4:
                System.out.println("Loai sach: Sach khac");
                break;
            default:
                System.out.println("Lua chon loai sach khong hop le!");
        }
    }
 public static void main(String[] args)
    {
        BTT3 sach = new BTT3();

        sach.nhap();
        if (sach.donGia > 0 && sach.soLuong >= 0
                && sach.namXuatBan >= 1 && sach.namXuatBan <= 2026)
        {
            System.out.println("Thong tin sach hop le.");

            sach.tinhTien();
            sach.xuat();
            sach.phanLoaiGia();
            sach.phanLoaiTonKho();
            sach.hienThiLoaiSach();
        }
        else
        {
            System.out.println("Thong tin sach khong hop le!");
            if (sach.donGia <= 0)
            {
                System.out.println("Don gia phai lon hon 0.");
            }
            if (sach.soLuong < 0)
            {
                System.out.println("So luong phai lon hon hoac bang 0.");
            }
            if (sach.namXuatBan < 1 || sach.namXuatBan > 2026)
            {
                System.out.println("Nam xuat ban phai tu 1 den 2026.");
            }
        }
    }
}