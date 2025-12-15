package src.ui;

import src.model.AxialCoordinate;

import java.awt.Point;
import java.awt.geom.Path2D;

class HexGeometry {
	static final double[] HEX_COS = new double[6];
	static final double[] HEX_SIN = new double[6];
	private static final double SQRT3 = Math.sqrt(3);
	static {
		for (int i = 0; i < 6; i++) {
			double angle = Math.toRadians(60 * i);
			HEX_COS[i] = Math.cos(angle);
			HEX_SIN[i] = Math.sin(angle);
		}
	}
	private double radius;
	HexGeometry(double radius) {
		this.radius = radius;
	}
	double getHexSize() {
		return radius;
	}
	Point hexToPixel(int q, int r, int cx, int cy) {
		double width = 2 * radius;
		double height = SQRT3 * radius;
		double quarterWidth = width * 3 / 4;
		double halfHeight = height / 2;
		int dx = (int) (quarterWidth * (q - r));
		int dy = (int) (halfHeight * (q + r));
		return new Point(cx + dx, cy + dy);
	}
	private AxialCoordinate hexRound(double q, double r) {
		double s = -q - r;
		int rq = (int) Math.round(q);
		int rr = (int) Math.round(r);
		int rs = (int) Math.round(s);
		double dq = Math.abs(rq - q);
		double dr = Math.abs(rr - r);
		double ds = Math.abs(rs - s);
		if (dq > dr && dq > ds)
			rq = -rr - rs;
		else if (dr > ds)
			rr = -rq - rs;
		return new AxialCoordinate(rq, rr);
	}
	AxialCoordinate pixelToHex(int x, int y, int cx, int cy) {
		double dx = x - cx;
		double dy = y - cy;
		double width = 2 * radius;
		double height = SQRT3 * radius;
		double quarterWidth = width * 3 / 4;
		double halfHeight = height / 2;
		double q = (dy / halfHeight + dx / quarterWidth) / 2;
		double r = (dy / halfHeight - dx / quarterWidth) / 2;
		return hexRound(q, r);
	}
	Path2D createHexPath(Point center) {
		Path2D path = new Path2D.Double();
		for (int i = 0; i < 6; i++) {
			double vx = center.x + radius * HEX_COS[i];
			double vy = center.y + radius * HEX_SIN[i];
			if (i == 0)
				path.moveTo(vx, vy);
			else
				path.lineTo(vx, vy);
		}
		path.closePath();
		return path;
	}
}