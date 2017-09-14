package com.kocomer.iot.entity;

/**
 * Created by kocomer on 2017/9/12.
 */

public class RouterEntity {
    public Router[] routers = new Router[0];

    public void createRouter(int length) {
        routers = new Router[length];
        for (int i = 0; i < length; i++) {
            routers[i] = new Router();
        }
    }

    public class Router {
        public String id;
        public String name;
        public String serial;
        public boolean online;
        public RouterClient[] clients = new RouterClient[0];

        public void crateClient(int length) {
            clients = new RouterClient[length];
            for (int i = 0; i < length; i++) {
                clients[i] = new RouterClient();
            }
        }
    }

    public class RouterClient {
        public String id;
        public String name;
        public String date;
        public String update;
    }
}
