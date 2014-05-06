public class MobileOperators {
    public static String mostlyUsed(String[] numbers) {
        int[] op = new int[3];

        for (String s : numbers) {
            String pre = s.substring(0, 3);
            if (pre.equalsIgnoreCase("071") || pre.equalsIgnoreCase("070")
                    || pre.equalsIgnoreCase("072")) {
                op[0]++;
            } else if (pre.equalsIgnoreCase("075")
                    || pre.equalsIgnoreCase("076")) {
                op[1]++;
            } else if (pre.equalsIgnoreCase("077")
                    || pre.equalsIgnoreCase("078")) {
                op[2]++;
            }
        }

        if (op[0] >= op[1] && op[0] >= op[2]) {
            return "Operator A";
        }
        if (op[1] >= op[0] && op[1] >= op[2]) {
            return "Operator B";
        }
        if (op[2] >= op[0] && op[2] >= op[1]) {
            return "Operator C";
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(mostlyUsed(new String[] { "071222-333",
                "077111-222", "072123-123", "075321-321" }));
    }
}
