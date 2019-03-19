package com.qxdo.demo.controller;

import com.qxdo.demo.common.Result;
import com.qxdo.demo.entity.Node;
import com.qxdo.demo.exception.ExceptionEnum;
import com.qxdo.demo.service.service.NodeService;
import com.qxdo.demo.util.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @GetMapping("/list")
    public Result listNode(){

        List<Node> nodeList  =  nodeService.listAllNodes();
        if( null ==  nodeList  || nodeList.size() < 0  ){
            return ResultTool.FAIL();
        }
        return ResultTool.SUCCESS(nodeList);
    }

    @GetMapping("/update")
    public Result deleteNode(@RequestParam Integer id,
                             @RequestParam Integer pid,
                             @RequestParam String label,
                             @RequestParam Integer leaf,
                             @RequestParam String url,
                             @RequestParam Integer rank){
        Node node = new Node(id,pid,label,leaf,url,rank);

        if(nodeService.updateNode(node)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }


    @GetMapping("/delete/{id}/{pid}")
    public Result deleteNode(@PathVariable Integer id,@PathVariable Integer pid){
        Node pnode = new Node(pid,null,null,1,null,null);
        if(nodeService.updateNode(pnode)){
            Node node = new Node(id,null,null,null,null,null);
            if(nodeService.deleteNode(node)){
                return ResultTool.SUCCESS();
            }

        }
        return ResultTool.FAIL();
    }

    @PostMapping("/save")
    public Result saveNode(@RequestParam String label,
                           @RequestParam Integer pid,
                           @RequestParam String url,
                           @RequestParam Integer rank,
                           @RequestParam Integer leaf){
        Node pnode = new Node(pid,null,null,0,null,null);


        //System.out.println("label:"+label+ "pid:"+pid+"url:"+url+"rank:"+rank+"leaf:"+leaf);



        nodeService.updateNode(pnode);
        Node node = new Node();



        node.setLeaf(leaf);
        node.setPid(pid);
        node.setRank(rank);
        node.setLabel(label);
        node.setUrl(url);

        nodeService.saveNode(node);
        //System.out.println("addNode:" + node);
        return ResultTool.SUCCESS(node);

    }
}
