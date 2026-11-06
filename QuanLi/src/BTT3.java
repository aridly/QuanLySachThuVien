import java.util.Scanner;

public class BTT3
{
    protected static Scanner sc = new Scanner(System.in);
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
    protected BTT3[] danhSach;
    protected int n;

    public void nhap()
    {
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
        sc.nextLine();
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

    public void nhapDanhSach()
    {
        System.out.print("Nhap so loai sach: ");
        n = sc.nextInt();
        sc.nextLine();

        if (n <= 0)
        {
            System.out.println("So loai sach phai lon hon 0.");
        }
        else
        {
            danhSach = new BTT3[n];

            for (int i = 0; i < n; i++)
            {
                System.out.println("\nNhap sach thu " + (i + 1));

                danhSach[i] = new BTT3();
                danhSach[i].nhap();

                if (danhSach[i].donGia > 0
                        && danhSach[i].soLuong >= 0
                        && danhSach[i].namXuatBan >= 1
                        && danhSach[i].namXuatBan <= 2026)
                {
                    danhSach[i].tinhTien();
                    danhSach[i].xuat();
                    danhSach[i].phanLoaiGia();
                    danhSach[i].phanLoaiTonKho();
                    danhSach[i].hienThiLoaiSach();
                }
                else
                {
                    System.out.println("Thong tin khong hop le! Nhap lai.");
                    i--;
                }
            }
        }
    }

    public void tinhTong()
    {
        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (int i = 0; i < n; i++)
        {
            tongSoLuong = tongSoLuong + danhSach[i].soLuong;

            tongGiaTri = tongGiaTri
                    + danhSach[i].donGia * danhSach[i].soLuong;
        }

        System.out.println("Tong so luong sach: " + tongSoLuong);
        System.out.println("Tong gia tri sach: " + tongGiaTri + " VND");
    }

    public void menu()
    {
        int chon;

        do
        {
            System.out.println("\n--- MENU QUAN LY SACH ---");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Tinh tong so luong va tong gia tri");
            System.out.println("3. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon)
            {
                case 1:
                    nhapDanhSach();
                    break;

                case 2:
                    if (n > 0)
                    {
                        tinhTong();
                    }
                    else
                    {
                        System.out.println("Chua nhap danh sach sach.");
                    }
                    break;

                case 3:
                    if (n > 0)
                    {
                        timSach();
                    }
                    else
                    {
                        System.out.println("Chua nhap danh sach sach.");
                    }
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        while (chon != 0);
    }

    public void timSach()
    {
        String maCanTim;
        int dem = 0;

        System.out.print("Nhap ma sach can tim: ");
        maCanTim = sc.nextLine();

        for (int i = 0; i < n; i++)
        {
            if (danhSach[i].maSach.equals(maCanTim))
            {
                danhSach[i].tinhTien();
                danhSach[i].xuat();
                dem++;
            }
        }

        if (dem == 0)
        {
            System.out.println("Khong tim thay sach.");
        }
    }

    public static void main(String[] args)
    {
        BTT3 quanLi = new BTT3();
        quanLi.menu();
    }
}