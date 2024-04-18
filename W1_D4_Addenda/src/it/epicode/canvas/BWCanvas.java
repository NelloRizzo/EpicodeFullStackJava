package it.epicode.canvas;

public class BWCanvas implements Canvas {

	private int width;
	private int height;
	protected boolean grid[][];

	public BWCanvas(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new boolean[height][width];
	}

	@Override
	public float getWidth() {
		return width;
	}

	@Override
	public float getHeight() {
		return height;
	}

	private void setPoint(float x, float y, boolean isOn) {
		int _x = (int) x;
		int _y = (int) y;
		if (_x > -1 && _x < width && _y >= 0 && _y < height) {
			grid[_y][_x] = isOn;
		}
	}

	@Override
	public void setPoint(float x, float y) {
		setPoint(x, y, true);
	}

	@Override
	public void resetPoint(float x, float y) {
		setPoint(x, y, false);
	}

	@Override
	public void clear() {
		for (int r = 0; r < height; ++r)
			for (int c = 0; c < width; ++c)
				grid[r][c] = false;
	}

	@Override
	public void line(float x0, float y0, float x1, float y1) {
		int _x0 = (int) x0;
		int _x1 = (int) x1;
		int _y0 = (int) y0;
		int _y1 = (int) y1;
		if (_x1 == _x0) {
			int miny = _y0 > _y1 ? _y1 : _y0;
			int maxy = _y0 > _y1 ? _y0 : _y1;
			for (int y = miny; y <= maxy; ++y)
				setPoint(x0, y);
		} else {
			int minx = _x0 > _x1 ? _x1 : _x0;
			int maxx = _x0 > _x1 ? _x0 : _x1;
			float m = (y0 - y1) / (x0 - x1);
			float q = (x0 * y1 - x1 * y0) / (x0 - x1);
			for (int x = minx; x < maxx; ++x) {
				int y = (int) (m * x + q);
				setPoint(x, y);
			}
		}
	}

	@Override
	public boolean isOn(float x, float y) {
		int _x = (int) x;
		int _y = (int) y;
		if (_x > -1 && _x < width && _y >= 0 && _y < height) {
			return grid[_y][_x];
		}
		return false;
	}
}
