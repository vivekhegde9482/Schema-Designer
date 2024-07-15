package com.draw.elements;

import java.util.concurrent.ThreadLocalRandom;

public class ForeignKey implements Element{
    private String id;
    private String parent;
    private String source;
    private String target;

    public ForeignKey(){
        this.id = String.valueOf(ThreadLocalRandom.current().nextInt());
    }

    @Override
    public String getID() {
        return null;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setHeight() {

    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getId() {
        return id;
    }

}
