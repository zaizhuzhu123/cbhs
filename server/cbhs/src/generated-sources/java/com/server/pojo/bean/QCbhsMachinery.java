package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMachinery is a Querydsl query type for CbhsMachinery
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMachinery extends EntityPathBase<CbhsMachinery> {

    private static final long serialVersionUID = -252987534L;

    public static final QCbhsMachinery cbhsMachinery = new QCbhsMachinery("cbhsMachinery");

    public final StringPath machineryTypeName = createString("machineryTypeName");

    public final NumberPath<Integer> machineryTypeOid = createNumber("machineryTypeOid", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<java.math.BigDecimal> p_zjf = createNumber("p_zjf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zpf = createNumber("p_zpf", java.math.BigDecimal.class);

    public final NumberPath<Integer> selfOrLease = createNumber("selfOrLease", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public final StringPath style = createString("style");

    public final NumberPath<Integer> used = createNumber("used", Integer.class);

    public QCbhsMachinery(String variable) {
        super(CbhsMachinery.class, forVariable(variable));
    }

    public QCbhsMachinery(Path<? extends CbhsMachinery> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMachinery(PathMetadata metadata) {
        super(CbhsMachinery.class, metadata);
    }

}

