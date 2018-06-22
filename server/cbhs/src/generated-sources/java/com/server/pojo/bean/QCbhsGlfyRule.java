package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsGlfyRule is a Querydsl query type for CbhsGlfyRule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsGlfyRule extends EntityPathBase<CbhsGlfyRule> {

    private static final long serialVersionUID = -1571404688L;

    public static final QCbhsGlfyRule cbhsGlfyRule = new QCbhsGlfyRule("cbhsGlfyRule");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<java.math.BigDecimal> p_kdqqysds_rule = createNumber("p_kdqqysds_rule", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_sjgs_rule = createNumber("p_sjgs_rule", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_yhsjqtsj_rule = createNumber("p_yhsjqtsj_rule", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_ztbfy_rule = createNumber("p_ztbfy_rule", java.math.BigDecimal.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public QCbhsGlfyRule(String variable) {
        super(CbhsGlfyRule.class, forVariable(variable));
    }

    public QCbhsGlfyRule(Path<? extends CbhsGlfyRule> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsGlfyRule(PathMetadata metadata) {
        super(CbhsGlfyRule.class, metadata);
    }

}

