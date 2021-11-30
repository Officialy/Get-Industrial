graph TD
ls(Liquid steel)

  subgraph Arc furnace method
  ioa(Iron)
  cda(Coal dust)
  ele{Graphite electrodes}
  pa{Power}
  af[Arc Furnace]

  ioa & cda & ele & pa --> af
  af -->ls
  end

  subgraph Blast furnace method
    subgraph Coke oven
    ca(Coal)
    coke(Coke)
    co[Coke Oven]

    ca --> co
    co --> coke
    end


  iob(Iron)
  lb(Limestone)
  bf[Blast furnace]

  iob & lb & coke --> bf
  bf --> ls
  end
