import java.util.Scanner;
import java.util.ArrayList;

public class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<Sach>();
        System.out.print("Nhap so cuon sach: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++)
        {
            System.out.println("\nNhap sach thu " + (i + 1));
            Sach sach = new Sach();
            System.out.print("Nhap ma sach: ");
            sach.maSach = sc.nextLine();
            System.out.print("Nhap tieu de: ");
            sach.tieuDe = sc.nextLine();
            System.out.print("Nhap tac gia: ");
            sach.tacGia = sc.nextLine();
            System.out.print("Nhap nam xuat ban: ");
            sach.namXuatBan = sc.nextInt();
            System.out.print("Nhap so luong: ");
            sach.soLuong = sc.nextInt();
            sc.nextLine();
            danhSachSach.add(sach);
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