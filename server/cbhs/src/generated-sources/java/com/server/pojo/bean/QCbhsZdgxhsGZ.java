package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZdgxhsGZ is a Querydsl query type for CbhsZdgxhsGZ
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZdgxhsGZ extends EntityPathBase<CbhsZdgxhsGZ> {

    private static final long serialVersionUID = -1299483595L;

    public static final QCbhsZdgxhsGZ cbhsZdgxhsGZ = new QCbhsZdgxhsGZ("cbhsZdgxhsGZ");

    public final NumberPath<Integer> grCount = createNumber("grCount", Integer.class);

    public final NumberPath<java.math.BigDecimal> gzhj = createNumber("gzhj", java.math.BigDecimal.class);

    public final NumberPath<Integer> gzOid = createNumber("gzOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> gzprice = createNumber("gzprice", java.math.BigDecimal.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> zytjOid = createNumber("zytjOid", Integer.class);

    public QCbhsZdgxhsGZ(String variable) {
        super(CbhsZdgxhsGZ.class, forVariable(variable));
    }

    public QCbhsZdgxhsGZ(Path<? extends CbhsZdgxhsGZ> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZdgxhsGZ(PathMetadata metadata) {
        super(CbhsZdgxhsGZ.class, metadata);
    }

}

