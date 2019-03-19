package com.qxdo.demo.dao;

import com.qxdo.demo.entity.Node;
import com.qxdo.demo.provider.NodeProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NodeDao {

    @Select("select * from node")
    List<Node> listNodes();

    @Insert("insert into node(label,pid,leaf,url,rank) values(#{node.label},#{node.pid},#{node.leaf},#{node.url},#{node.rank})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    Integer saveNode(@Param("node") Node node);




    @UpdateProvider(type = NodeProvider.class,method = "updateNode")
    Integer updateNode(@Param("node") Node node);

    @Delete("delete from node where id= #{node.id}")
    Integer deleteNode(@Param("node") Node node);
}
