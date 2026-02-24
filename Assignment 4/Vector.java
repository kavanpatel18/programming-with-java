public class Vector {

    private double[] components;

    // Constructor
    public Vector(double[] arr) throws VectorException {

        if (arr.length != 2 && arr.length != 3) {
            throw new VectorException("Vector must be strictly 2D or 3D.");
        }

        components = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            components[i] = arr[i];
        }
    }

    // Getter for dimension
    public int getDimension() {
        return components.length;
    }

    // Add
    public Vector add(Vector v1) throws VectorException {

        if (this.getDimension() != v1.getDimension()) {
            throw new VectorException("Addition requires same dimensions.");
        }

        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] + v1.components[i];
        }

        return new Vector(result);
    }

    // Subtract
    public Vector subtract(Vector v1) throws VectorException {

        if (this.getDimension() != v1.getDimension()) {
            throw new VectorException("Subtraction requires same dimensions.");
        }

        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] - v1.components[i];
        }

        return new Vector(result);
    }

    // Dot Product
    public double dotProduct(Vector v1) throws VectorException {

        if (this.getDimension() != v1.getDimension()) {
            throw new VectorException("Dot product requires same dimensions.");
        }

        double sum = 0;

        for (int i = 0; i < components.length; i++) {
            sum += this.components[i] * v1.components[i];
        }

        return sum;
    }

    // Print
    public void printVector() {

        System.out.print("(");

        for (int i = 0; i < components.length; i++) {
            System.out.print(components[i]);
            if (i < components.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(")");
    }
}