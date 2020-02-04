public class DefangingIpAddress {

    public String solution(final String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        DefangingIpAddress solution = new DefangingIpAddress();
        System.out.println(solution.solution("123.123.123.1"));
    }
}
