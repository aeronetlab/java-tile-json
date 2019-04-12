package ru.skoltech.aeronetlab.tilejson;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TileJsonBuilder {

    private String tilejson = "2.2.0";

    private String name;

    private String description;

    private String version = "1.0.0";

    private String attribution;

    private String template;

    private String legend;

    private String scheme = "xyz";

    private String[] tiles = new String[0];

    private String[] grids = new String[0];

    private String[] data = new String[0];

    private int minzoom = 0;

    private int maxzoom = 30;

    private double[] bounds = {-180, -85.05112877980659, 180, 85.0511287798066};

    private double[] center = {-76.275329586789, 39.153492567373, 8};

    public TileJsonBuilder setTilejson(String tilejson) {
        this.tilejson = tilejson;
        return this;
    }

    public TileJsonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TileJsonBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TileJsonBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public TileJsonBuilder setAttribution(String attribution) {
        this.attribution = attribution;
        return this;
    }

    public TileJsonBuilder setTemplate(String template) {
        this.template = template;
        return this;
    }

    public TileJsonBuilder setLegend(String legend) {
        this.legend = legend;
        return this;
    }

    public TileJsonBuilder setScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    public TileJsonBuilder setTiles(String[] tiles) {
        this.tiles = tiles;
        return this;
    }

    public TileJsonBuilder setGrids(String[] grids) {
        this.grids = grids;
        return this;
    }

    public TileJsonBuilder setData(String[] data) {
        this.data = data;
        return this;
    }

    public TileJsonBuilder setMinzoom(int minzoom) {
        this.minzoom = minzoom;
        return this;
    }

    public TileJsonBuilder setMaxzoom(int maxzoom) {
        this.maxzoom = maxzoom;
        return this;
    }

    public TileJsonBuilder setBounds(double[] bounds) {
        this.bounds = bounds;
        return this;
    }

    public TileJsonBuilder setCenter(double[] center) {
        this.center = center;
        return this;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> tileJson = new HashMap<>();

        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                tileJson.put(field.getName(), field.get(this));
            } catch (IllegalAccessException e) {
                //unreachable
                throw new RuntimeException("Cannot build TileJson.", e);
            }
        }

        return tileJson;
    }
}
