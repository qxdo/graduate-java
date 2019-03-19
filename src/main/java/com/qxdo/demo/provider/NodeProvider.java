package com.qxdo.demo.provider;

import org.apache.ibatis.annotations.Param;
import com.qxdo.demo.entity.Node;
import org.apache.ibatis.jdbc.SQL;

public class NodeProvider {
    public String updateNode(@Param("node")Node node){
        return new SQL(){
            {
                UPDATE("node");
                if(node.getLabel()!=null){
                    SET("label = #{node.label}");
                }
                if(node.getLeaf()!=null){
                    SET("leaf = #{node.leaf}");
                }
                if(node.getPid()!=null){
                    SET("pid = #{node.pid}");
                }
                if(node.getRank()!=null){
                    SET("rank = #{node.rank}");
                }
                if(node.getUrl()!=null){
                    SET("url = #{node.url}");
                }
                WHERE("id = #{node.id}");

            }
        }.toString();

    }
}
