package service;

import service.annotations.ComponentAnno;

/**
 * Created by 37 on 2016/9/27.
 */
@ComponentAnno(serviceName = "Scene",
        gameobjectName = "Player",
        actionEventIds = {1000, 1001},
        gameEventIds = {"event1", "event2"})
public class SampleComponent implements Component{
}
