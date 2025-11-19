package dev.elephantintheroom.practice.halvecompoundshape;

public record Point(float x, float y) {
    public Point add(Point other) {
        return new Point(x + other.x, y + other.y);
    }

    public Point divideBy(float divisor) {
        return new Point(x / divisor, y / divisor);
    }

    public float distance(Point other) {
        return (float) Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}
