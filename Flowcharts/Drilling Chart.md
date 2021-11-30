graph TD
    subgraph Low density drilling fluid
    lw(Desalinated water)
    ld(Dirt)
    lc(Clay)
    mixerl[Drilling fluid mixer]
    lddf(Low density drilling fluid)
    pl{Power}

    lw & ld & lc & pl --> mixerl
    mixerl --> lddf
    end


    subgraph Low to high density drilling fluid
    lddf(Low density drilling fluid)
    add(Salt, Lye, or Barite)
    mixerlh[Drilling fluid mixer]
    hddf(High density drilling fluid)
    plh{Power}

    lddf & add & plh --> mixerlh
    mixerlh --> hddf
    end


    subgraph High density drilling fluid
    ho(Oil)
    hd(Dirt)
    hc(Clay)
    mixerh[Drilling fluid mixer]
    hddf(High density drilling fluid)
    ph{Power}

    ho & hd & hc & ph --> mixerh
    mixerh --> hddf
    end


    subgraph Pressurization without additive
    mp[Mud pump]
    pddf(Pressurized drilling fluid)
    pmp{Power}

    lddf & hddf & pmp --> mp
    mp --> pddf
    end


    subgraph Pressurization with additive
    mpa[Mud pump]
    saw(Sawdust)
    pddfa(Pressurized sawdust drilling fluid)
    pmpa{Power}

    lddf & hddf & pmpa & saw --> mpa
    mpa --> pddfa
    end

    subgraph Drilling
    d[Drill]
    pd{Power}
    o(Ore chunks)
    ng(Natural Gas)

    pddf & pddfa & pd --> d
    d --> o & ng
    end
