import java.util.*;

public class Sleep
{
	
	public  ArrayList<ActivityData> loadData(String dataString)
    {
        ArrayList<ActivityData> data = new ArrayList<>();

        String[] tempData = dataString.split("\n");

        long timeStamp;
        short intensity;
        short steps;
        byte category;
        short heartValue = 0;
        int valoreAtteso = 0;

        for (int i = 0; i <tempData.length;i++)
        {
            String [] lineTemp = tempData[i].split(";");

            category = Byte.decode(lineTemp[0]);
            intensity = Short.decode(lineTemp[1]);
            steps = Short.decode(lineTemp[2]);
            timeStamp = Long.decode(lineTemp[3]);
			
			valoreAtteso = -1;
			if(lineTemp.length>4 && lineTemp[4]!="")
				valoreAtteso = Integer.decode(lineTemp[4]);

            data.add(new ActivityData(timeStamp, intensity, steps, category, heartValue, valoreAtteso));
        }

        return data;
    } 
	
	
	public int getMode(int category, int intensity, int steps, double Distance, double max, double mode)
	{

if (mode == -1) return 0;
if (mode == 0) {
    if (Distance <= 0) return 0;
    if (Distance > 0) {
        if (Distance <= 4) {
            if (max <= 52) {
                if (max <= 27) {
                    if (Distance <= 2) {
                        if (max <= 22) {
                            if (max <= 19) {
                                if (Distance <= 1) {
                                    if (max <= 12) {
                                        if (max <= 6) return 0;
                                        if (max > 6) return 1;
                                    }
                                    if (max > 12) return 0;
                                }
                                if (Distance > 1) return 0;
                            }
                            if (max > 19) {
                                if (Distance <= 1) {
                                    if (intensity <= 0) return 0;
                                    if (intensity > 0) return 1;
                                }
                                if (Distance > 1) return 0;
                            }
                        }
                        if (max > 22) {
                            if (max <= 26) {
                                if (max <= 25) return 0;
                                if (max > 25) return 1;
                            }
                            if (max > 26) return 0;
                        }
                    }
                    if (Distance > 2) {
                        if (Distance <= 3) {
                            if (max <= 2) return 0;
                            if (max > 2) {
                                if (intensity <= 0) return 0;
                                if (intensity > 0) return 1;
                            }
                        }
                        if (Distance > 3) {
                            if (intensity <= 0) {
                                if (max <= 13) return 1;
                                if (max > 13) {
                                    if (max <= 22) return 0;
                                    if (max > 22) {
                                        if (max <= 24) return 1;
                                        if (max > 24) return 0;
                                    }
                                }
                            }
                            if (intensity > 0) return 0;
                        }
                    }
                }
                if (max > 27) {
                    if (intensity <= 31) {
                        if (max <= 33) {
                            if (Distance <= 3) {
                                if (Distance <= 2) {
                                    if (max <= 29) {
                                        if (max <= 28) return 1;
                                        if (max > 28) return 0;
                                    }
                                    if (max > 29) return 1;
                                }
                                if (Distance > 2) return 1;
                            }
                            if (Distance > 3) {
                                if (max <= 28) return 0;
                                if (max > 28) {
                                    if (max <= 29) return 1;
                                    if (max > 29) {
                                        if (max <= 30) return 0;
                                        if (max > 30) return 1;
                                    }
                                }
                            }
                        }
                        if (max > 33) {
                            if (Distance <= 1) return 0;
                            if (Distance > 1) return 1;
                        }
                    }
                    if (intensity > 31) {
                        if (steps <= 5) return 0;
                        if (steps > 5) {
                            if (steps <= 12) {
                                if (Distance <= 1) return 1;
                                if (Distance > 1) {
                                    if (Distance <= 3) return 0;
                                    if (Distance > 3) return 1;
                                }
                            }
                            if (steps > 12) return 1;
                        }
                    }
                }
            }
            if (max > 52) return 0;
        }
        if (Distance > 4) return 0;
    }
}
if (mode == 1) return 0;
if (mode == 3) return 0;
if (mode == 4) {
    if (max <= 19) return 0;
    if (max > 19) {
        if (Distance <= 0) {
            if (max <= 24) return 0;
            if (max > 24) {
                if (max <= 27) {
                    if (intensity <= 22) return 1;
                    if (intensity > 22) return 0;
                }
                if (max > 27) return 0;
            }
        }
        if (Distance > 0) {
            if (Distance <= 1) return 1;
            if (Distance > 1) return 0;
        }
    }
}
if (mode == 5) {
    if (Distance <= 4) {
        if (Distance <= 3) {
            if (max <= 15) {
                if (max <= 1) return 0;
                if (max > 1) {
                    if (Distance <= 1) {
                        if (Distance <= 0) return 0;
                        if (Distance > 0) {
                            if (intensity <= 5) return 0;
                            if (intensity > 5) return 1;
                        }
                    }
                    if (Distance > 1) {
                        if (max <= 3) {
                            if (Distance <= 2) {
                                if (intensity <= 0) return 1;
                                if (intensity > 0) {
                                    if (intensity <= 2) return 0;
                                    if (intensity > 2) return 1;
                                }
                            }
                            if (Distance > 2) {
                                if (intensity <= 0) return 0;
                                if (intensity > 0) {
                                    if (intensity <= 1) return 1;
                                    if (intensity > 1) return 0;
                                }
                            }
                        }
                        if (max > 3) {
                            if (Distance <= 2) return 1;
                            if (Distance > 2) {
                                if (intensity <= 5) return 1;
                                if (intensity > 5) return 0;
                            }
                        }
                    }
                }
            }
            if (max > 15) {
                if (Distance <= 0) {
                    if (max <= 53) {
                        if (max <= 32) {
                            if (intensity <= 2) return 1;
                            if (intensity > 2) return 0;
                        }
                        if (max > 32) {
                            if (max <= 43) return 1;
                            if (max > 43) {
                                if (max <= 45) return 0;
                                if (max > 45) return 1;
                            }
                        }
                    }
                    if (max > 53) return 0;
                }
                if (Distance > 0) {
                    if (max <= 30) {
                        if (max <= 17) return 1;
                        if (max > 17) {
                            if (max <= 28) {
                                if (max <= 19) {
                                    if (max <= 18) {
                                        if (intensity <= 14) return 1;
                                        if (intensity > 14) return 0;
                                    }
                                    if (max > 18) return 0;
                                }
                                if (max > 19) return 1;
                            }
                            if (max > 28) {
                                if (max <= 29) return 0;
                                if (max > 29) {
                                    if (intensity <= 2) return 0;
                                    if (intensity > 2) return 1;
                                }
                            }
                        }
                    }
                    if (max > 30) {
                        if (intensity <= 33) return 1;
                        if (intensity > 33) {
                            if (max <= 69) {
                                if (max <= 36) {
                                    if (max <= 35) {
                                        if (max <= 34) return 1;
                                        if (max > 34) {
                                            if (Distance <= 2) return 1;
                                            if (Distance > 2) return 0;
                                        }
                                    }
                                    if (max > 35) return 0;
                                }
                                if (max > 36) return 1;
                            }
                            if (max > 69) return 0;
                        }
                    }
                }
            }
        }
        if (Distance > 3) return 1;
    }
    if (Distance > 4) return 0;
}
if (mode == 6) return 0;
if (mode == 12) return 0;
if (mode == 17) return 0;


		
		return 0;
	}
	
}