package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZdgxhsMachine is a Querydsl query type for CbhsZdgxhsMachine
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZdgxhsMachine extends EntityPathBase<CbhsZdgxhsMachine> {

    private static final long serialVersionUID = -941020635L;

    public static final QCbhsZdgxhsMachine cbhsZdgxhsMachine = new QCbhsZdgxhsMachine("cbhsZdgxhsMachine");

    public final NumberPath<java.math.BigDecimal> completeTotal = createNumber("completeTotal", java.math.BigDecimal.class);

    public final StringPath machineryName = createString("machineryName");

    public final NumberPath<Integer> machineryOid = createNumber("machineryOid", Integer.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<java.math.BigDecimal> p_jxdxf = createNumber("p_jxdxf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_jxysf = createNumber("p_jxysf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_total = createNumber("p_total", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zjf = createNumber("p_zjf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zpf = createNumber("p_zpf", java.math.BigDecimal.class);

    public final NumberPath<Integer> ryID = createNumber("ryID", Integer.class);

    public final StringPath ryKemuName = createString("ryKemuName");

    public final StringPath ryName = createString("ryName");

    public final NumberPath<java.math.BigDecimal> ryPrice = createNumber("ryPrice", java.math.BigDecimal.class);

    public final StringPath ryStyle = createString("ryStyle");

    public final StringPath ryUnit = createString("ryUnit");

    public final NumberPath<java.math.BigDecimal> ryUnitPrice = createNumber("ryUnitPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> ryUseCount = createNumber("ryUseCount", java.math.BigDecimal.class);

    public final NumberPath<Float> workTime = createNumber("workTime", Float.class);

    public final NumberPath<Integer> zytjOid = createNumber("zytjOid", Integer.class);

    public QCbhsZdgxhsMachine(String variable) {
        super(CbhsZdgxhsMachine.class, forVariable(variable));
    }

    public QCbhsZdgxhsMachine(Path<? extends CbhsZdgxhsMachine> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZdgxhsMachine(PathMetadata metadata) {
        super(CbhsZdgxhsMachine.class, metadata);
    }

}

