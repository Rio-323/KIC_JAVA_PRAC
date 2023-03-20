class Address {
    String hakbun;
    String name;
    String number;

    Address(String hakbun, String name, String number) {
        this.hakbun = hakbun;
        this.name = name;
        this.number = number;
    }
}
public class ArrayEx09 {
    public static void main(String[] args) {
        String[][] addressArr = new String[][] 
        { { "1001", "홍길동", "010-1111-1111" }, { "1002", "박문수", "010-2222-2222" }, { "1003", "홍길동", "010-3333-3333" }};

        // for (int i = 0; i < addressArr.length; i++) {
        //     for (int j = 0; j < addressArr.length; j++) {
        //         System.out.print(addressArr[i][j] + "\t");
        //     }
        //     System.out.println();
        // }

        Address[] address = new Address[3];
        // Address address1 = new Address("1001", "홍길동", "010-1111-1111");
        // Address address2 = new Address("1002", "박문수", "010-2222-2222");
        // Address address3 = new Address("1003", "이몽룡", "010-3333-3333");
        address[0] = new Address("1001", "홍길동", "010-1111-1111");
        address[1] = new Address("1002", "박문수", "010-2222-2222");
        address[2] = new Address("1003", "이몽룡", "010-3333-3333");

        for (int i = 0; i < address.length; i++) {
            System.out.print(address[i].hakbun + "\t");
            System.out.print(address[i].name + "\t");
            System.out.print(address[i].number + "\t");
            System.out.println();
        }

        for(Address address4 : address) {
            System.out.print(address4.hakbun + "\t");
            System.out.print(address4.name + "\t");
            System.out.print(address4.number + "\t");
            System.out.println();
        }
    }
}
