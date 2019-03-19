package com.qxdo.demo.service.impl;

import com.qxdo.demo.dao.NodeDao;
import com.qxdo.demo.entity.Node;
import com.qxdo.demo.service.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service("nodeService")
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeDao nodeDao;
    @Override
    public List<Node> listAllNodes() {

        List<Node> nodes =  nodeDao.listNodes();
        if(null != nodes && nodes.size() > 0){
            return nodes;
        }
        return null;
    }

    @Override
    public boolean saveNode(Node node) {
        return nodeDao.saveNode(node) ==1 ;
    }

    @Override
    public boolean updateNode(Node node) {
        return nodeDao.updateNode(node) == 1;
    }

    @Override
    public boolean deleteNode(Node node) {
        return nodeDao.deleteNode(node) == 1;
    }
}
