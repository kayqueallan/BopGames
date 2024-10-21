public class Duracao {
    private int horas;
    private int minutos;
    private int segundos;

    public Duracao(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        normalizar(); // Normaliza para garantir que a duração está em uma forma válida
    }

    // Método para normalizar a duração
    private void normalizar() {
        if (segundos >= 60) {
            minutos += segundos / 60;
            segundos = segundos % 60;
        }
        if (minutos >= 60) {
            horas += minutos / 60;
            minutos = minutos % 60;
        }
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public Duracao adicionar(Duracao outra) {
        return new Duracao(
                this.horas + outra.horas,
                this.minutos + outra.minutos,
                this.segundos + outra.segundos
        );
    }

    public Duracao calcularDiferenca(Duracao outra) {
        int totalSegundos1 = this.toSegundos();
        int totalSegundos2 = outra.toSegundos();
        int diferencaSegundos = Math.abs(totalSegundos1 - totalSegundos2);

        return fromSegundos(diferencaSegundos);
    }

    public int toSegundos() {
        return this.horas * 3600 + this.minutos * 60 + this.segundos;
    }

    private static Duracao fromSegundos(int segundos) {
        int horas = segundos / 3600;
        segundos %= 3600;
        int minutos = segundos / 60;
        segundos %= 60;

        return new Duracao(horas, minutos, segundos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Duracao)) return false;
        Duracao outra = (Duracao) obj;
        return this.horas == outra.horas &&
                this.minutos == outra.minutos &&
                this.segundos == outra.segundos;
    }

    @Override
    public int hashCode() {
        return 31 * horas + 7 * minutos + segundos;
    }

    @Override
    public String toString() {
        return horas + " horas, " + minutos + " minutos e " + segundos + " segundos";
    }
}
