import java.util.HashMap;
import java.util.List;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> p:paths){
            map.put(p.get(0),p.get(1));
        }
        String d=paths.get(0).get(0);
        while(map.containsKey(d)){
            d=map.get(d);
        }
        return d;
    }
    /**
     the approach is we will create a HashMap of Source to Destination
     now here after creating the map, i traverse over the values of map, that is all the destinations of the source

     the optimisation here done is
     we pick the first source given to us and then iterate over the destinations until we get a point for which we don't have any where else to go

     by doing this we don't have to travel all the values of map
     as from source there will definately a path to end so only 1 path is traversed not all */
}

class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> p:paths){
            map.put(p.get(0),p.get(1));
        }
        String d=paths.get(0).get(0);
        while(map.containsKey(d)){
            d=map.get(d);
        }
        return d;
    }
}

/**
 the approach is we will create a HashMap of Source to Destination
 now here after creating the map, i traverse over the values of map, that is all the destinations of the source

 the optimisation here done is
 we pick the first source given to us and then iterate over the destinations until we get a point for which we don't have any where else to go

 by doing this we don't have to travel all the values of map
 as from source there will definately a path to end so only 1 path is traversed not all */
