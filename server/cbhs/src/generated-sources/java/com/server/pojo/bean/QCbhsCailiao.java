package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsCailiao is a Querydsl query type for CbhsCailiao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsCailiao extends EntityPathBase<CbhsCailiao> {

    private static final long serialVersionUID = -1696463782L;

    public static final QCbhsCailiao cbhsCailiao = new QCbhsCailiao("cbhsCailiao");

    public final StringPath kemuName = createString("kemuName");

    public final NumberPath<Integer> kemuOid = createNumber("kemuOid", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public final StringPath style = createString("style");

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsCailiao(String variable) {
        super(CbhsCailiao.class, forVariable(variable));
    }

    public QCbhsCailiao(Path<? extends CbhsCailiao> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsCailiao(PathMetadata metadata) {
        super(CbhsCailiao.class, metadata);
    }

}

