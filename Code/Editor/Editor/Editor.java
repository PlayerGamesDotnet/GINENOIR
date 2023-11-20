public class CompilerAndArchDetector {
    public static void main(String[] args) {
        // Verificando o compilador e a arquitetura em Java
        String compiler = System.getProperty("java.compiler");
        String architecture = System.getProperty("os.arch");

        if (compiler != null && compiler.contains("Eclipse")) {
            System.out.println("COMPILER: Eclipse");
        } else if (compiler != null && compiler.contains("Microsoft")) {
            System.out.println("COMPILER: Microsoft");
            if (architecture != null && architecture.contains("64")) {
                System.out.println("ARCH: x64");
            } else if (architecture != null && architecture.contains("86")) {
                System.out.println("ARCH: x86");
            } else if (architecture != null && architecture.contains("arm")) {
                System.out.println("ARCH: arm");
            } else {
                System.out.println("Unhandled architecture for Microsoft compiler");
            }
        } else if (compiler != null && compiler.contains("Other")) {
            System.out.println("COMPILER: Other");
            // Verificar outras arquiteturas para o compilador "Other"
        } else {
            System.out.println("Unhandled compiler");
        }
    }
}
