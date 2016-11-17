package com.wscq.test.htmlparser;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.math.BigDecimal;

/**
 * Created by monst on 2016/11/17.
 */
public class HttpParser {

    /**
     * 获得主要节点，适用地址：
     * https://world.taobao.com/item/537658870360.htm?fromSite=main&spm=a1z10.3-c-s.w4002-14949738229.10.nxKD7Y
     *
     * @param url
     * @return
     * @throws ParserException
     */
    public NodeList getNodeList(String url) throws ParserException {

        Parser parser = new Parser(url);

        // 设置两个过滤点
//        NodeFilter filter = (NodeFilter) node -> node.getText().contains("id=\"J_Title\"");
        NodeFilter filter = (NodeFilter) node -> node.getText().contains("itemprop=\"name\"");

//        NodeFilter sencdFilter = (NodeFilter) node -> node.getText().contains("id=\"J_priceStd\"");
        NodeFilter sencdFilter = (NodeFilter) node -> node.getText().contains("itemprop=\"price\"");

        OrFilter allFilter = new OrFilter(filter, sencdFilter);
        // 进行过滤
        return parser.extractAllNodesThatMatch(allFilter);
    }

    public Goods getGoods(String url) throws ParserException {
        NodeList nodeList = getNodeList(url);
        System.out.println(nodeList.size() + nodeList.asString());
        Goods goods = new Goods();
        if (nodeList.size() == 2) {
            Node node = nodeList.elementAt(0);
            goods.setGoodsName(node.toPlainTextString());
            node = nodeList.elementAt(1);
            goods.setPrice(BigDecimal.valueOf(Double.parseDouble(node.toPlainTextString())));
        } else {
            throw new RuntimeException();
        }
        return goods;
    }
}
