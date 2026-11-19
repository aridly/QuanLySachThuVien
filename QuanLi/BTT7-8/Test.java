import java.util.Scanner;
import java.util.ArrayList;
import java.time.Year;

public class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<Sach>();

        int namHienTai = Year.now().getValue();

        System.out.print("Nhap so cuon sach: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++)
        {
            System.out.println("\nNhap sach thu " + (i + 1));

            System.out.print("Nhap ma sach: ");
            String maSach = sc.nextLine();

            System.out.print("Nhap tieu de: ");
            String tieuDe = sc.nextLine();

            System.out.print("Nhap tac gia: ");
            String tacGia = sc.nextLine();

            System.out.print("Nhap nam xuat ban: ");
            int namXuatBan = sc.nextInt();

            System.out.print("Nhap so luong: ");
            int soLuong = sc.nextInt();
            sc.nextLine();

            if (namXuatBan > 0 && namXuatBan <= namHienTai
                    && soLuong >= 0)
            {
                Sach sach = new Sach(
                    maSach, tieuDe, tacGia, namXuatBan, soLuong);

                danhSachSach.add(sach);
                System.out.println("Da them sach.");
            }
            else
            {
                System.out.println(
                    "Nam xuat ban hoac so luong khong hop le. Khong them sach.");
            }
        }

        System.out.println("\n--- DANH SACH SACH ---");

        for (int i = 0; i < danhSachSach.size(); i++)
        {
            System.out.println("\nSach thu " + (i + 1));
            danhSachSach.get(i).hienThiThongTin();
        }

        sc.close();
    }
}