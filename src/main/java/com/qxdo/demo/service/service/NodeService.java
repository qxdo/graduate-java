package com.qxdo.demo.service.service;


import com.qxdo.demo.entity.Node;

import java.util.List;

public interface NodeService {

    List<Node> listAllNodes();

    boolean saveNode(Node node);

    boolean updateNode(Node node);

    boolean deleteNode(Node node);
}
