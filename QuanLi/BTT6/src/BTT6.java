import java.util.Scanner;
import java.util.ArrayList;

public class BTT6
{
    protected static Scanner sc = new Scanner(System.in);
    protected ArrayList<String> danhSachMa = new ArrayList<String>();
    protected ArrayList<String> danhSachSach = new ArrayList<String>();
    public void bai1()
    {
        int[] soLuong = new int[5];
        int tong = 0;

        for (int i = 0; i < soLuong.length; i++)
        {
            do
            {
                System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
                soLuong[i] = sc.nextInt();

                if (soLuong[i] < 0)
                {
                    System.out.println("So luong khong duoc am!");
                }
            }
            while (soLuong[i] < 0);
        }
        sc.nextLine();

        int lonNhat = soLuong[0];

        System.out.println("\n--- SO LUONG SACH ---");

        for (int i = 0; i < soLuong.length; i++)
        {
            System.out.println("Sach thu " + (i + 1) + ": " + soLuong[i]);

            tong = tong + soLuong[i];

            if (soLuong[i] > lonNhat)
            {
                lonNhat = soLuong[i];
            }
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + lonNhat);
    }
    public void bai2()
    {
        int chon;
        String ma;

        do
        {
            System.out.println("\n--- QUAN LY MA SACH ---");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon)
            {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    ma = sc.nextLine();

                    if (danhSachMa.contains(ma))
                    {
                        System.out.println("Ma sach da ton tai.");
                    }
                    else
                    {
                        danhSachMa.add(ma);
                        System.out.println("Da them ma sach.");
                    }
                    break;

                case 2:
                    if (danhSachMa.size() == 0)
                    {
                        System.out.println("Danh sach rong.");
                    }
                    else
                    {
                        for (int i = 0; i < danhSachMa.size(); i++)
                        {
                            System.out.println(danhSachMa.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma can tim: ");
                    ma = sc.nextLine();

                    if (danhSachMa.contains(ma))
                    {
                        System.out.println("Tim thay ma sach: " + ma);
                    }
                    else
                    {
                        System.out.println("Khong tim thay ma sach.");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma can xoa: ");
                    ma = sc.nextLine();

                    if (danhSachMa.contains(ma))
                    {
                        danhSachMa.remove(ma);
                        System.out.println("Da xoa ma sach.");
                    }
                    else
                    {
                        System.out.println("Khong tim thay ma sach.");
                    }
                    break;

                case 0:
                    System.out.println("Quay lai menu chinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        while (chon != 0);
    }
    public String nhapThongTinSach()
    {
        String maSach;
        String tenSach;
        double donGia;
        int soLuong;
        do
        {
            System.out.print("Nhap ma sach (khong chua dau ;): ");
            maSach = sc.nextLine();
        }
        while (maSach.trim().isEmpty() || maSach.contains(";"));

        do
        {
            System.out.print("Nhap ten sach (khong chua dau ;): ");
            tenSach = sc.nextLine();
        }
        while (tenSach.trim().isEmpty() || tenSach.contains(";"));

        do
        {
            System.out.print("Nhap don gia: ");
            donGia = sc.nextDouble();

            if (donGia <= 0)
            {
                System.out.println("Don gia phai lon hon 0.");
            }
        }
        while (donGia <= 0);

        do
        {
            System.out.print("Nhap so luong: ");
            soLuong = sc.nextInt();

            if (soLuong < 0)
            {
                System.out.println("So luong khong duoc am.");
            }
        }
        while (soLuong < 0);

        sc.nextLine();

        return maSach + ";" + tenSach + ";" + donGia + ";" + soLuong;
    }

    public void xuatThongTinSach(String thongTin)
    {
        String[] sach = thongTin.split(";");

        System.out.println("Ma sach: " + sach[0]);
        System.out.println("Ten sach: " + sach[1]);
        System.out.println("Don gia: " + sach[2] + " VND");
        System.out.println("So luong: " + sach[3]);
    }

    public int timViTriSach(String maCanTim)
    {
        for (int i = 0; i < danhSachSach.size(); i++)
        {
            String[] sach = danhSachSach.get(i).split(";");

            if (sach[0].equals(maCanTim))
            {
                return i;
            }
        }

        return -1;
    }

    public void themSach()
    {
        String thongTin = nhapThongTinSach();
        String[] sach = thongTin.split(";");

        if (timViTriSach(sach[0]) != -1)
        {
            System.out.println("Ma sach da ton tai. Khong them.");
        }
        else
        {
            danhSachSach.add(thongTin);
            System.out.println("Da them sach.");
        }
    }

    public void hienThiSach()
    {
        if (danhSachSach.size() == 0)
        {
            System.out.println("Danh sach rong.");
        }
        else
        {
            for (int i = 0; i < danhSachSach.size(); i++)
            {
                System.out.println("\n--- SACH THU " + (i + 1) + " ---");
                xuatThongTinSach(danhSachSach.get(i));
            }
        }
    }

    public void timSach()
    {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();

        int viTri = timViTriSach(ma);

        if (viTri == -1)
        {
            System.out.println("Khong tim thay sach.");
        }
        else
        {
            xuatThongTinSach(danhSachSach.get(viTri));
        }
    }

    public void xoaSach()
    {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();

        int viTri = timViTriSach(ma);

        if (viTri == -1)
        {
            System.out.println("Khong tim thay sach.");
        }
        else
        {
            danhSachSach.remove(viTri);
            System.out.println("Da xoa sach.");
        }
    }
    public void suaSach()
    {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();

        int viTri = timViTriSach(ma);

        if (viTri == -1)
        {
            System.out.println("Khong tim thay sach.");
        }
        else
        {
            System.out.println("Nhap thong tin moi:");
            String thongTin = nhapThongTinSach();
            String[] sach = thongTin.split(";");

            int viTriTrung = timViTriSach(sach[0]);

            if (viTriTrung != -1 && viTriTrung != viTri)
            {
                System.out.println("Ma sach trung voi sach khac. Khong sua.");
            }
            else
            {
                danhSachSach.set(viTri, thongTin);
                System.out.println("Da sua sach.");
            }
        }
    }

    public void tinhTongSoLuong()
    {
        long tong = 0;

        for (int i = 0; i < danhSachSach.size(); i++)
        {
            String[] sach = danhSachSach.get(i).split(";");
            int soLuong = Integer.parseInt(sach[3]);

            tong = tong + soLuong;
        }

        System.out.println("Tong so luong sach: " + tong);
    }

    public void tinhTongGiaTri()
    {
        double tong = 0;

        for (int i = 0; i < danhSachSach.size(); i++)
        {
            String[] sach = danhSachSach.get(i).split(";");

            double donGia = Double.parseDouble(sach[2]);
            int soLuong = Integer.parseInt(sach[3]);

            tong = tong + donGia * soLuong;
        }

        System.out.println("Tong gia tri sach: " + tong + " VND");
    }

    // BAI 4: Menu quan ly sach
    public void menuQuanLySach()
    {
        int chon;

        do
        {
            System.out.println("\n--- MENU QUAN LY SACH ---");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon)
            {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSach();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("Da thoat menu quan ly sach.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        while (chon != 8);
    }
    public void menu()
    {
        int chon;

        do
        {
            System.out.println("\n--- BAI THUC HANH TUAN 6 ---");
            System.out.println("1. Bai 1: Mang so luong sach");
            System.out.println("2. Bai 2: Danh sach ma sach");
            System.out.println("3. Bai 3 va 4: Quan ly sach");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon)
            {
                case 1:
                    bai1();
                    break;
                case 2:
                    bai2();
                    break;
                case 3:
                    menuQuanLySach();
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
    public static void main(String[] args)
    {
        BTT6 quanLi = new BTT6();
        quanLi.menu();
        sc.close();
    }
}