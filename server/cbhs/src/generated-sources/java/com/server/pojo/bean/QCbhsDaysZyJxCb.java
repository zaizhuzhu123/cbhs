package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsDaysZyJxCb is a Querydsl query type for CbhsDaysZyJxCb
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsDaysZyJxCb extends EntityPathBase<CbhsDaysZyJxCb> {

    private static final long serialVersionUID = -1339375809L;

    public static final QCbhsDaysZyJxCb cbhsDaysZyJxCb = new QCbhsDaysZyJxCb("cbhsDaysZyJxCb");

    public final NumberPath<java.math.BigDecimal> completeCount = createNumber("completeCount", java.math.BigDecimal.class);

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath globalGclYsName = createString("globalGclYsName");

    public final NumberPath<Integer> globalGclYsOid = createNumber("globalGclYsOid", Integer.class);

    public final StringPath machineryName = createString("machineryName");

    public final NumberPath<Integer> machineryOid = createNumber("machineryOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> p_clysf = createNumber("p_clysf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_jxdxf = createNumber("p_jxdxf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zjf = createNumber("p_zjf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zpf = createNumber("p_zpf", java.math.BigDecimal.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final StringPath ryKemuName = createString("ryKemuName");

    public final StringPath ryName = createString("ryName");

    public final NumberPath<Integer> ryOid = createNumber("ryOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> ryPrice = createNumber("ryPrice", java.math.BigDecimal.class);

    public final StringPath ryStyle = createString("ryStyle");

    public final StringPath ryUnit = createString("ryUnit");

    public final NumberPath<java.math.BigDecimal> ryUnitPrice = createNumber("ryUnitPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> ryUseCount = createNumber("ryUseCount", java.math.BigDecimal.class);

    public final StringPath shId = createString("shId");

    public final NumberPath<Integer> shStatus = createNumber("shStatus", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> workTimer = createNumber("workTimer", java.math.BigDecimal.class);

    public QCbhsDaysZyJxCb(String variable) {
        super(CbhsDaysZyJxCb.class, forVariable(variable));
    }

    public QCbhsDaysZyJxCb(Path<? extends CbhsDaysZyJxCb> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsDaysZyJxCb(PathMetadata metadata) {
        super(CbhsDaysZyJxCb.class, metadata);
    }

}

