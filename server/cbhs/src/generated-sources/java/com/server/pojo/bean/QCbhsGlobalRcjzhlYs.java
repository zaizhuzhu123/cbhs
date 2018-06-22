package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsGlobalRcjzhlYs is a Querydsl query type for CbhsGlobalRcjzhlYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsGlobalRcjzhlYs extends EntityPathBase<CbhsGlobalRcjzhlYs> {

    private static final long serialVersionUID = 436499102L;

    public static final QCbhsGlobalRcjzhlYs cbhsGlobalRcjzhlYs = new QCbhsGlobalRcjzhlYs("cbhsGlobalRcjzhlYs");

    public final NumberPath<java.math.BigDecimal> c_cy = createNumber("c_cy", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_fdlg = createNumber("c_fdlg", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_fmh = createNumber("c_fmh", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_gj = createNumber("c_gj", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_gksn = createNumber("c_gksn", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_nq = createNumber("c_nq", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_sha = createNumber("c_sha", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_shi = createNumber("c_shi", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_shui = createNumber("c_shui", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_sn = createNumber("c_sn", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_tpzs = createNumber("c_tpzs", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_wjj = createNumber("c_wjj", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> c_zy = createNumber("c_zy", java.math.BigDecimal.class);

    public final StringPath count = createString("count");

    public final NumberPath<java.math.BigDecimal> j_wjjyy = createNumber("j_wjjyy", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> j_yyldz = createNumber("j_yyldz", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> j_zxqc = createNumber("j_zxqc", java.math.BigDecimal.class);

    public final StringPath name = createString("name");

    public final StringPath nodeId = createString("nodeId");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> r_jx = createNumber("r_jx", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> r_qt = createNumber("r_qt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> r_rg = createNumber("r_rg", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> r_unitHj = createNumber("r_unitHj", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> r_zc = createNumber("r_zc", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> rg_count = createNumber("rg_count", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> tong = createNumber("tong", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> totaPrice = createNumber("totaPrice", java.math.BigDecimal.class);

    public final StringPath unit = createString("unit");

    public QCbhsGlobalRcjzhlYs(String variable) {
        super(CbhsGlobalRcjzhlYs.class, forVariable(variable));
    }

    public QCbhsGlobalRcjzhlYs(Path<? extends CbhsGlobalRcjzhlYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsGlobalRcjzhlYs(PathMetadata metadata) {
        super(CbhsGlobalRcjzhlYs.class, metadata);
    }

}

