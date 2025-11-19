package dev.elephantintheroom.practice.halvecompoundshape;

import java.util.*;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class ConvexPolygon {
    private final Point[] points;
    private final Point center;
    private final float area;

    public ConvexPolygon(Point[] points) {
        this.points = points;
        if (points.length < 3) {
            throw new IllegalArgumentException("Minimum 3 points required to create a convex polygon");
        }

        center = Arrays.stream(points).reduce((acc, p) -> acc.add(p.divideBy(points.length))).get();

        if (points.length == 3) {
            float semiperimeter = (
                    points[0].distance(points[1])
                            + points[1].distance(points[2])
                            + points[2].distance(points[0])
            ) / 2;
            this.area = (float) Math.sqrt(
                    semiperimeter
                            * (semiperimeter - points[0].distance(points[1]))
                            * (semiperimeter - points[1].distance(points[2]))
                            * (semiperimeter - points[2].distance(points[0]))
            );
        } else {
            class GathererState {
                Point first;
                Point last;
            }
            Gatherer<Point, GathererState, Point[]> adjacentPoints = Gatherer.ofSequential(
                    GathererState::new,
                    Gatherer.Integrator.of((state, element, downstream) -> {
                        if (state.first == null) state.first = element;
                        if (state.last != null) downstream.push(new Point[]{state.last, element});
                        state.last = element;
                        return true;
                    }),
                    (state, downstream) -> {
                        downstream.push(new Point[]{state.last, state.first});
                    }
            );
            this.area = (float) Arrays.stream(points)
                    .gather(adjacentPoints)
                    .mapToDouble(edge -> new ConvexPolygon(new Point[] { edge[0], edge[1], center }).area)
                    .sum();
        }
    }

    public ConvexPolygon halve(Edge[] edgesToPreserve) {
        var withEdgesBroughtIn = bringInEdges(edgesToPreserve);
        if (withEdgesBroughtIn.area < area / 2) return withEdgesBroughtIn;
    }

    private ConvexPolygon bringInEdges(Edge[] edgesToPreserve) {

    }
}
