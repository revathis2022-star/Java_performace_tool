// NormalProgram.java
class NormalProgram {

    public static void main(String[] args) {
        long startTime = System.nanoTime();  // Start timer

        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from Normal Java Program " + i);
        }

        long endTime = System.nanoTime();  // End timer
        long duration = (endTime - startTime);
        System.out.println("Execution Time (ns): " + duration);
    }
}
