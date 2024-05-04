package Graphics;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.awt.Point;

public class ButtonLayout implements LayoutManager2 {

    public enum Alignment {
        VERTICAL, HORIZONTAL
    }

    public enum Anchor {
        LEADING, CENTER, TRAILING
    }

    private Alignment alignment;
    private Anchor anchor;
    private int padding;

    private Dimension virtualBounds;

    public ButtonLayout() {
        this(Alignment.HORIZONTAL, Anchor.TRAILING, 0);
    }

    public ButtonLayout(Alignment alignment, Anchor anchor) {
        this(alignment, anchor, 0);
    }

    public ButtonLayout(Alignment alignment, Anchor anchor, int padding) {
        this.alignment = alignment;
        this.padding = padding;
        this.anchor = anchor;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public Anchor getAnchor() {
        return anchor;
    }

    protected int getPadding() {
        return padding;
    }

    protected int getTotalPadding(Container parent) {
        int padding = getPadding();
        return (padding * parent.getComponentCount()) - padding;
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public void invalidateLayout(Container target) {
        virtualBounds = null;
    }

    protected Dimension virtualLayout(Container parent) {
        if (virtualBounds != null) {
            return virtualBounds;
        }
        int maxWidth = 0;
        int maxHeight = 0;

        for (Component component : parent.getComponents()) {
            Dimension preferredSize = component.getPreferredSize();
            maxHeight = Math.max(maxHeight, preferredSize.height);
            maxWidth = Math.max(maxWidth, preferredSize.width);
        }

        int padding = 0;
        int width = 0;
        int height = 0;
        int componentCount = parent.getComponentCount();
        switch (alignment) {
            case HORIZONTAL:
                width = (maxWidth * componentCount) + getTotalPadding(parent);
                height = maxHeight;
                break;
            case VERTICAL:
                width = maxWidth;
                height = (maxHeight * componentCount) + getTotalPadding(parent);
                break;
        }

        virtualBounds = new Dimension(width, height);
        return virtualBounds;
    }

    @Override
    public Dimension maximumLayoutSize(Container parent) {
        return virtualLayout(parent);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return virtualLayout(parent);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return virtualLayout(parent);
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0.5f;
    }

    @Override
    public void layoutContainer(Container parent) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (Component component : parent.getComponents()) {
            Dimension preferredSize = component.getPreferredSize();
            maxHeight = Math.max(maxHeight, preferredSize.height);
            maxWidth = Math.max(maxWidth, preferredSize.width);
        }

        Dimension defaultSize = new Dimension(maxWidth, maxHeight);
        Point point = offsetForAnchor(parent, defaultSize);

        int xDelta = 0;
        int yDelta = 0;
        switch (alignment) {
            case HORIZONTAL:
                xDelta = getPadding() + defaultSize.width;
                break;
            case VERTICAL:
                yDelta = getPadding() + defaultSize.height;
                break;
        }
        for (Component component : parent.getComponents()) {
            component.setSize(defaultSize);
            component.setLocation(point);
            point = new Point(point.x + xDelta, point.y + yDelta);
        }
    }

    protected Point offsetForAnchor(Container parent, Dimension defaultSize) {
        switch (anchor) {
            case LEADING:
                return leadingOffSet(parent, defaultSize);
            case TRAILING:
                return trailingOffSet(parent, defaultSize);
            case CENTER:
                return centerOffSet(parent, defaultSize);
        }
        return new Point(0, 0);
    }

    protected Point leadingOffSet(Container parent, Dimension defaultSize) {
        Point point = new Point(0, 0);
        switch (alignment) {
            case HORIZONTAL:
                point.x = padding;
                point.y = (parent.getHeight() - defaultSize.height) / 2;
                break;
            case VERTICAL:
                point.x = (parent.getWidth() - defaultSize.width) / 2;
                point.y = padding;
                break;
        }
        return point;
    }

    protected Point trailingOffSet(Container parent, Dimension defaultSize) {
        Point point = new Point(0, 0);
        int componentCount = parent.getComponentCount();
        switch (alignment) {
            case HORIZONTAL:
                int totalWidth = (defaultSize.width * componentCount) + getTotalPadding(parent);
                point.x = parent.getWidth() - totalWidth;
                point.y = (parent.getHeight() - defaultSize.height) / 2;
                break;
            case VERTICAL:
                int totalHeight = (defaultSize.height * componentCount) + getTotalPadding(parent);
                point.x = (parent.getWidth() - defaultSize.width) / 2;
                point.y = parent.getHeight() - totalHeight;
                break;
        }
        return point;
    }

    protected Point centerOffSet(Container parent, Dimension defaultSize) {
        Point point = new Point(0, 0);
        int componentCount = parent.getComponentCount();
        switch (alignment) {
            case HORIZONTAL: {
                int totalWidth = (defaultSize.width * componentCount) + getTotalPadding(parent);
                point.x = (parent.getWidth() - totalWidth) / 2;
                point.y = (parent.getHeight() - defaultSize.height) / 2;
            }
            break;
            case VERTICAL: {
                int totalHeight = (defaultSize.height * componentCount) + getTotalPadding(parent);
                point.x = (parent.getWidth() - defaultSize.width) / 2;
                point.y = (parent.getHeight() - totalHeight) / 2;
            }
            break;
        }
        return point;
    }

}
