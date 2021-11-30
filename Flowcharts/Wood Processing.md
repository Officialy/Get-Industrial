graph TD
  subgraph Log Stripper
  l(Log)
  pls{Power}
  ls[Log Stripper]
  sl(Stripped Log)
  lssd(Sawdust)

  l & pls --> ls
  ls --> sl & lssd
  end


  subgraph Hewsaw
  phw{Power}
  hw[Hewsaw]
  p(Planks 6x)
  sd(Sawdust x3)

  sl & phw --> hw
  hw --> p & sd
  end


  subgraph Chipper
  chp{Power}
  ch[Chipper]
  wch(Wood Chips x4)

  sl & chp --> ch
  ch --> wch
  end


  subgraph Pulping
  sdwp(Sawdust)
  hmp{Power}
  hm[Hammer Mill]
  wp(Wood Pulp)

  sdwp & hmp & wch --> hm
  hm --> wp
  end


  subgraph Paper Mill
  pppm{Power}
  ppm[Paper Mill]
  ctr[Cutter]
  pps(Paper Spool)
  pp(Paper x3)

  wp & pppm --> ppm
  ppm --> pps
  pps  & pppm --> ctr
  ctr --> pp
  end


  subgraph Wood Pellets
  pm[Pellet Mill]
  pmp{Power}
  woodp(Wood Pellets)

  wp & pmp --> pm
  pm --> woodp
  end
